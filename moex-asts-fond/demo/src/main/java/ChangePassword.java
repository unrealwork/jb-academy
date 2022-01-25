import com.axibase.asts.client.MoexAstsClient;
import com.axibase.asts.client.Clients;
import com.axibase.asts.client.config.UserCredentials;
import com.axibase.asts.client.transaction.TransactionResult;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ChangePassword {
    public static void main(String[] args) throws Exception {
        try (MoexAstsClient client = Clients.defaultClient()) {
            UserCredentials userCredentials = client.getConfig().getUserCredentials();
            TransactionResult result = client.changePassword(userCredentials.getPassword());
            if (result.isSuccess()) {
                log.info("Password changed. " + result.getMessage());
            } else {
                log.error("Unable to change password. " + result.getMessage());
            }
        }
    }
}
