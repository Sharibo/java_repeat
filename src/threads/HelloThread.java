package threads;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from " + getName() + "!");

        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(100);

                System.out.println(Thread.currentThread().getName() + " - " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
    
}
