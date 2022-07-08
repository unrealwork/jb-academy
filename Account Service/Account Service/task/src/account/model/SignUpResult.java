package account.model;


import account.model.persistance.User;

public class SignUpResult {
    private final long id;

    private SignUpResult(long id, String name, String lastname, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }

    private final String name;
    private final String lastname;
    private final String email;

    public static SignUpResult fromUser(User request) {
        return new SignUpResult(request.getId(), request.getName(), request.getLastname(), request.getUsername());
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
}
