import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Main {
    // Do not change it
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int messageCounts = scanner.nextInt();
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < messageCounts; ++i) {
            messages.add(scanner.next());
        }

        MailSender sender = new MockMailSender();
        asyncSend(sender, messages);
    }

    static void asyncSend(MailSender sender, List<String> messages) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        messages.forEach(m -> executor.execute(() -> sender.send(m)));
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Do not change it
interface MailSender {
    void send(String message);
}

// The class simulatse mail sending
// Do not change it
class MockMailSender implements MailSender {
    public void send(String message) {
        System.out.println("Message " + message + " was sent");
    }
}
