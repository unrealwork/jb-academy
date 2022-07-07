package account.model;


import account.api.SignUpRequest;

public class SignUpResult {
    private final String name;
    private final String lastname;
    private final String email;


    private SignUpResult(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
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
    
    public static SignUpResult fromRequest(SignUpRequest request) {
        return new SignUpResult(request.getName(), request.getLastname(), request.getEmail());
    }
}
