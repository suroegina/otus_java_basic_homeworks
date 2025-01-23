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
                        while (ready.isReady_B() || ready.isReady_C()) {
                            monitor.wait();
                        }
                        ready.setReady_B(true);
                        ready.setReady_A(false);
                    } else if (ch == 'B') {
                        while (ready.isReady_A() || ready.isReady_C()) {
                            monitor.wait();
                        }
                        ready.setReady_C(true);
                        ready.setReady_B(false);
                    } else if (ch == 'C') {
                        while (ready.isReady_B() || ready.isReady_A()) {
                            monitor.wait();
                        }
                        ready.setReady_A(true);
                        ready.setReady_C(false);
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