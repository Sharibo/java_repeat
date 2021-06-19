package threads.synchronization;

public class SyncMain3 {

    static Monitor monitor = new Monitor();

    public static void main(String[] args) {

        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("1 - " + i);

                    if (i >= 50) {
                        synchronized (monitor) {
                            monitor.x = i;
                            monitor.notify();
                        }
                    }
                }

            }

        });

        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    synchronized (monitor) {
                        while (monitor.x < 50) {
                            monitor.wait();

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("2 - " + i);
                }

            }

        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Monitor {
    int x;
}