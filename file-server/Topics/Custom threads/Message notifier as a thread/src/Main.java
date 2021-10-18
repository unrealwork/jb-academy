class MessageNotifier extends Thread {
    private final int repeates;
    private final String msg;

    // write fields to store variables here

    public MessageNotifier(String msg, int repeats) {
        // implement the constructor
        this.msg = msg;
        this.repeates = repeats;
    }

    @Override
    public void run() {
        // implement the method to print the message stored in a field
        for (int i = 0; i < repeates; i++) {
            System.out.println(msg);
        }
    }
}
