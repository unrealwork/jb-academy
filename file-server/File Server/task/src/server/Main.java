package server;

/** App's Entry point. */
public class Main {

  public static void main(String[] args) throws Exception {
    try (FileServer fileServer = FileServer.socket()) {
      fileServer.addMessageCallback(
          m -> {
            try {
              System.out.println("Received: " + m);
              final String message = "All files were sent!";
              fileServer.sendMessage(message);
              System.out.println("Sent: " + message);
              fileServer.stop();
            } catch (Exception e) {
              throw new IllegalStateException(e);
            }
          });
      System.out.println("Server started!");
      fileServer.start();
    }
  }
}
