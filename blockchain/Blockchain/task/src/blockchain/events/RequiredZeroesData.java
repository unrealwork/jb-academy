package blockchain.events;

public class RequiredZeroesData {
    private final int before;
    private final int after;

    private RequiredZeroesData(int before, int after) {
        this.before = before;
        this.after = after;
    }

    public static RequiredZeroesData create(int before, int after) {
        return new RequiredZeroesData(before, after);
    }

    public int getBefore() {
        return before;
    }

    public int getAfter() {
        return after;
    }
}
