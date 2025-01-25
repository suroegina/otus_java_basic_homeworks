import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintChars {
    private final Object monitor = new Object();
    private Ready ready = new Ready();

    public static void main(String[] args) {
        PrintChars waitNotifySimpleApp = new PrintChars();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() ->
            waitNotifySimpleApp.print('A')
        );
        service.execute(() ->
            waitNotifySimpleApp.print('B')
        );
        service.execute(() ->
            waitNotifySimpleApp.print('C')
        );
        service.shutdown();
    }

    private void performPrint(char ch) {
        System.out.print(ch);
    }

    private void waitForTurn(char ch) throws InterruptedException {
        while (!isTurn(ch)) {
            monitor.wait();
        }
    }

    private boolean isTurn(char ch) {
        return (ch == 'A' && !ready.isReadyB() && !ready.isReadyC()) ||
                (ch == 'B' && !ready.isReadyA() && !ready.isReadyC()) ||
                (ch == 'C' && !ready.isReadyA() && !ready.isReadyB());
    }

    private void updateReadyState(char ch) {
        if (ch == 'A') {
            ready.setReadyB(true);
            ready.setReadyA(false);
        } else if (ch == 'B') {
            ready.setReadyC(true);
            ready.setReadyB(false);
        } else if (ch == 'C') {
            ready.setReadyA(true);
            ready.setReadyC(false);
        }
    }


    public void print(char ch) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    waitForTurn(ch);
                    performPrint(ch);
                    updateReadyState(ch);
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}