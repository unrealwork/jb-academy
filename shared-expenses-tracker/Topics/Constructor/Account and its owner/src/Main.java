public static void main(String[] args) {

    // create an instance of Account here
    var acc = new Account("123456", 1000L, new User("demo-user", "Alexander", "Schmidt"));
    // pass it into process method
    process(acc);
}

static class Account {

    private String code;
    private Long balance;
    private User owner;

    public Account(String code, Long balance, User owner) {
        this.code = code;
        this.balance = balance;
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public Long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

static class User {

    private String login;
    private String firstName;
    private String lastName;

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
