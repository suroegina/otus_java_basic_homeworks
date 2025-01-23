import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintChars {
    private final Object monitor = new Object();
    private Ready ready = new Ready();

    public static void main(String[] args) {
        PrintChars waitNotifySimpleApp = new PrintChars();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> {
            waitNotifySimpleApp.print('A');
        });
        service.execute(() -> {
            waitNotifySimpleApp.print('B');
        });
        service.execute(() -> {
            waitNotifySimpleApp.print('C');
        });


        service.shutdown();
    }

    public void print(char ch) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    if (ch == 'A') {
                        while (ready.isReadyB() || ready.isReadyC()) {
                            monitor.wait();
                        }
                        ready.setReadyB(true);
                        ready.setReadyA(false);
                    } else if (ch == 'B') {
                        while (ready.isReadyA() || ready.isReadyC()) {
                            monitor.wait();
                        }
                        ready.setReadyC(true);
                        ready.setReadyB(false);
                    } else if (ch == 'C') {
                        while (ready.isReadyB() || ready.isReadyA()) {
                            monitor.wait();
                        }
                        ready.setReadyA(true);
                        ready.setReadyC(false);
                    } else {
                        continue;
                    }
                    System.out.print(ch);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}