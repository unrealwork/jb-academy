import com.axibase.asts.client.MoexAstsClient;
import com.axibase.asts.client.Clients;
import com.axibase.asts.client.model.ServerInfo;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AstsClientDemo {
    public static void main(String[] args) throws Exception {
        try (MoexAstsClient client = Clients.defaultClient()) {
            final ServerInfo serverInfo = client.serverInfo();
            log.info("Connected to server: {}", serverInfo);
        }

    }
}
