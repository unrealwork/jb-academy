import java.util.Scanner;
import java.util.concurrent.Callable;

class CallableUtil {
    public static Callable<String> getCallable() {
        // implement method
        return () -> {
            try (Scanner sc = new Scanner(System.in)) {
                return sc.next();
            }
        };
    }
}
