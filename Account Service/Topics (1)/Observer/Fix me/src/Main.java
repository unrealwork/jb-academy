import java.util.*;     

/** Observable */

/** Concrete Observable */
class RockstarGames {

    public String releaseGame;
    private final List<Gamer> observers = new java.util.ArrayList<>();

    public void release(String game) {
        this.releaseGame = game;
        /* write your code here ... */
        for (Gamer observer : observers) {
            System.out.println("Inform message to : " + observer.getName());
            observer.buyGame(game);
        }
    }
    
    public void addObserver(Gamer gamer) {
        observers.add(gamer);
    }
    
}

/** Observer */

/** Concrete Observer */
class Gamer {

    private String name;
    private String reaction;
    private Set<String> games = new HashSet<>();

    public Gamer(String name, String reaction) {
        this.reaction = reaction;
        this.name = name;
    }

    /* write your code here ... */

    public void buyGame(String game) {
        games.add(game);
        System.out.println(name + " says: " + reaction);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }
}

/** Main Class */

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        String game = null;

        Gamer garry = new Gamer("Garry Rose", "I want to pre-order");
        Gamer peter = new Gamer("Peter Johnston", "Pinch me...");
        Gamer helen = new Gamer("Helen Jack", "Jesus, it's new game from Rockstar!");
        
        /* write your code here ... */
        RockstarGames rockstarGames = new RockstarGames();
        
        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);
        
        game = scanner.nextLine();
        System.out.println("It's happened! RockstarGames releases new game - " + game + "!");

        /* write your code here ... */ 
        rockstarGames.release(game);

    }
}
