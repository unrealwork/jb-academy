import java.lang.reflect.Field;

final class AccountUtils {

    private AccountUtils() {
    }

    public static void increaseBalance(Account account, long amount) {
        // write your code here
        try {

            Field field = account.getClass().getDeclaredField("balance");
            field.setAccessible(true);
            long val = (long) field.get(account);
            field.set(account, val + amount);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
