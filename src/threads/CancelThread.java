package threads;

public class CancelThread implements Runnable {

    private Thread self;
    private static int ThreadCounters;
    private int ThreadID;
    private int counter;
    private volatile boolean canWork;

    public CancelThread() {
        ThreadID = ThreadCounters++;
        self = new Thread(this, "CancelThread");
        // self.start(); не рекомендуется
    }

    public int start() {
        canWork = true;
        self.start();
        return counter;
    }

    public int stop() {
        System.out.println("Sending stop!");
        canWork = false;
        return counter;
    }

    public int interrupt() {
        System.out.println("Sending interrupt!");
        self.interrupt();
        return counter;
    }

    public int join(int ms) throws InterruptedException {
        self.join(ms);
        return counter;
    }

    @Override
    public void run() {
        /* while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Interrupting...");
                break;
            }

            counter++;
        } */

        while (canWork) {
            counter++;
        }
    }

}
