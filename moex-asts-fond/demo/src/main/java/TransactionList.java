import com.axibase.asts.client.MoexAstsClient;
import com.axibase.asts.client.Clients;
import com.micex.client.Meta;
import lombok.extern.log4j.Log4j2;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Log4j2
public class TransactionList {
    public static void main(String[] args) throws Exception {
        try (MoexAstsClient client = Clients.defaultClient()) {
            Meta.Market market = client.marketInfo();
            for (Meta.Message transaction : market.transactions()) {
                log.info("{} - {}\nParams: \n{}\n Return: \n{}", transaction.name, transaction.description, fieldsDescription(transaction.params()),
                        fieldsDescription(transaction.output()));
            }
        }
    }

    private static String fieldsDescription(Meta.Fields fields) {

        return StreamSupport.stream(fields.spliterator(), false)
                .map(f -> f.name + " " + f.type() + f.description)
                .collect(Collectors.joining("\n\t", "\t", ""));
    }
}
