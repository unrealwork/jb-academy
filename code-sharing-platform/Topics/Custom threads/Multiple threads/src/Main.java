public class Main {
    public static void main(String[] args) throws InterruptedException {
        // create instances and start threads here
        final WorkerThread worker1 = new WorkerThread("worker-1");
        final WorkerThread worker2 = new WorkerThread("worker-2");
        worker1.start();
        worker2.start();
        worker1.join();
        worker2.join();
    }
}

// Don't change the code below
class WorkerThread extends Thread {
    private static final int NUMBER_OF_LINES = 3;

    public WorkerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (!name.startsWith("worker-")) {
            return;
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            System.out.println("do something...");
        }
    }
}
