package threads.array_sum;

public class SumThread extends Thread {

    private int position;

    public SumThread(int position) {
        this.position = position;
    }

    @Override
    public void run() {
        for (int i = position; i < GlobalData.ARRAY_LENGTH; i += GlobalData.THREADS_COUNT) {
            GlobalData.results[position] += GlobalData.array[i];
        }
    }

}
