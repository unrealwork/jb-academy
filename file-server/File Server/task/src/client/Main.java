package client;

@SuppressWarnings("squid:S106")
public class Main {
  public static void main(String[] args) throws Exception {
    try (SocketMessageClient client = SocketMessageClient.connect("127.0.0.1", 23456)) {
      System.out.println("Client started!");
      final String messageToSend = "Give me everything you have!";
      client.send(messageToSend);
      System.out.println("Sent: " + messageToSend);
      final String receivedMessage = client.receive();
      System.out.println("Received: " + receivedMessage);
    }
  }
}
