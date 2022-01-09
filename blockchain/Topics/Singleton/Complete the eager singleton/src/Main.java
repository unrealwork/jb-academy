class SimpleCounter {
    private static SimpleCounter instance = new SimpleCounter();
    public int counter;

    // write your code here
    private SimpleCounter() {
    }

    public static SimpleCounter getInstance() {
        return instance;
    }
}
