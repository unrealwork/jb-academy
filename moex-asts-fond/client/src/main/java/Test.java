import com.axibase.asts.client.MoexAstsClient;
import com.axibase.asts.client.Clients;

public class Test {
    static {
    }

    public static void main(String[] args) {
        MoexAstsClient client = Clients.defaultClient();
        client.connect();
        client.disconnect();
    }
}
