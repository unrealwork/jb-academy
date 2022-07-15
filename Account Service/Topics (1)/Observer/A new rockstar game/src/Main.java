import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Observable interface
 **/
interface Observable {
    // write your code here ...
    void addObserver(Observer observer);
}

/**
 * Concrete Observable - Rockstar Games
 **/
class RockstarGames implements Observable {

    public String releaseGame;
    private List<Observer> observers = new ArrayList<>();

    // write your code here ...

    public void release(String game) {
        this.releaseGame = game;
        // write your code here ...
        this.observers.forEach(observer -> {
            System.out.println("Notification for gamer : " + observer.getName());
            observer.buyGame(releaseGame);
        });
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
}

/**
 * Observer interface
 **/
interface Observer {
    // write your code here ...
    void buyGame(String game);

    String getName();
}

/**
 * Concrete observer - Gamer
 **/
class Gamer implements Observer {

    private String name;
    private Set<String> games = new HashSet<>();

    public Gamer(String name) {
        this.name = name;
    }

    // write your code here ...
    @Override
    public void buyGame(String game) {
        if (games.contains(game)) {
            System.out.println("What? They've already released this game ... I don't understand");
        } else {
            System.out.println(name + " says : \"Oh, Rockstar releases new game " + game + " !\"");
        }
        games.add(game);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/**
 * Main class
 **/
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose");
        Gamer peter = new Gamer("Peter Johnston");
        Gamer helen = new Gamer("Helen Jack");

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        for (int i = 0; i < 2; i++) {
            game = scanner.nextLine();
            rockstarGames.release(game);
        }
    }
}
