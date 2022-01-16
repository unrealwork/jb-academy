import java.util.Comparator;

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return Comparator
                .comparing(User::getName)
                .compare(user1, user2);
    }
}
