package server;

/** App's Entry point. */
public class Main {

  public static void main(String[] args) {
    FileServer fileServer = FileServer.simulation();
    fileServer.start();
  }
}
