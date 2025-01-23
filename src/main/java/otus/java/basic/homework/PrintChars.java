package otus.java.basic.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintChars {
    private final Object monitor = new Object();
    private Ready ready = new Ready();

    public static void main(String[] args) {
        PrintChars waitNotifySimpleApp = new PrintChars();
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> {
            waitNotifySimpleApp.printA();
        });
        service.execute(() -> {
            waitNotifySimpleApp.printB();
        });
        service.execute(() -> {
            waitNotifySimpleApp.printC();
        });


        service.shutdown();
    }
    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (ready.isReady_B() || ready.isReady_C()) {
                        monitor.wait();
                    }
                    System.out.print("A");
                    monitor.notifyAll();
                    ready.setReady_B(true);
                    ready.setReady_A(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (ready.isReady_A() || ready.isReady_C()) {
                        monitor.wait();
                    }
                    System.out.print("B");
                    monitor.notifyAll();
                    ready.setReady_C(true);
                    ready.setReady_B(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (ready.isReady_B() || ready.isReady_A()) {
                        monitor.wait();
                    }
                    System.out.print("C");
                    monitor.notifyAll();
                    ready.setReady_A(true);
                    ready.setReady_C(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}