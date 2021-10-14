package client;

@SuppressWarnings("squid:S106")
public class Main {
  public static void main(String[] args) throws Exception {
    try (FileClient client = FileClient.connect("127.0.0.1", 23456)) {
      System.out.println("Client started!");
      final String messageToSend = "Give me everything you have!";
      client.sendMessage(messageToSend);
      System.out.println("Sent: " + messageToSend);
      final String receivedMessage = client.recieveMessage();
      System.out.println("Received: " + receivedMessage);
    }
  }
}
