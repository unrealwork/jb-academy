package account.model;

public class ChangePasswordResult {
    private static final String SUCCSESS_MSG = "The password has been updated successfully";

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    private final String status;
    private final String email;

    public ChangePasswordResult(String status, String username) {
        this.status = status;
        this.email = username;
    }

    public static ChangePasswordResult success(String username) {
        return new ChangePasswordResult(SUCCSESS_MSG, username);
    }
}
