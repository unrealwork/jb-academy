import java.util.Arrays;

class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        // implement this method
        final Thread notStartedThread = Arrays.stream(threads)
                .filter(t -> t.getState() == Thread.State.NEW)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        notStartedThread.start();
        notStartedThread.join();
    }
}
