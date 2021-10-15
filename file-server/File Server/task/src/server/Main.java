package server;

/** App's Entry point. */
public class Main {

  public static void main(String[] args) throws Exception {
    try (ReqRespServer fileServer = Servers.file()) {
      fileServer.start();
    }
  }
}
