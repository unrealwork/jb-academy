import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws URISyntaxException {
        // put your code here
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            final String url = sc.next();
            final URI uri = new URI(url);
            final String query = uri.getQuery();
            final String[] kvs = query.split("&");
            final LinkedHashMap<String, String> paramsMap = new LinkedHashMap<>();
            for (String kv : kvs) {
                final String[] kvArray = kv.split("=", 2);
                final String k = kvArray[0];
                final String v = kvArray[1];
                paramsMap.put(k, v);
                System.out.printf("%s : %s%n", k, v.isEmpty() ? "not found" : v);
            }
            if (paramsMap.containsKey("pass")) {
                System.out.printf("password : %s", paramsMap.get("pass"));
            }
        }
    }
}
