package threads;

public class HelloMain {
    
    public static void main(String[] args) {
        
        System.out.println("Start of " + Thread.currentThread().getName());

        HelloThread thread1 = new HelloThread();
        HelloThread thread2 = new HelloThread();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Enf of main()");
    }
    
}
