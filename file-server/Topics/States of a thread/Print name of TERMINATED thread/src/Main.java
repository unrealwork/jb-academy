class ThreadUtil {
    static void printNameOfTerminatedThread(Thread[] threads) {
        // implement the method
        java.util.Arrays.stream(threads)
                .filter(t -> t.getState() == Thread.State.TERMINATED)
                .findFirst()
                .map(Thread::getName)
                .ifPresent(System.out::println);
    }
}
