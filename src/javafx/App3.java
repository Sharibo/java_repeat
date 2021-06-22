package javafx;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class App3 extends Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start of main()");

        MyTask task = new MyTask();
        new Thread(task).start();
        DoubleProperty progress = new SimpleDoubleProperty();
        progress.bind(task.progressProperty());

        while (!task.isDone()) {
            Thread.sleep(300);
            System.out.println(progress.get() + " working...");
        }

        System.out.println("End of main()");
        System.exit(0);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}

class MyTask extends Task<Void> {

    @Override
    protected Void call() throws Exception {
        System.out.println("JavaFX task!");

        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            updateProgress(i + 1, 10);
        }
        return null;
    }

    @Override
    protected void succeeded() {
        System.out.println("End of MyTask()");
    }

}