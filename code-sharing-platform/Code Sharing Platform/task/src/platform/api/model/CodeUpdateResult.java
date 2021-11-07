package platform.api.model;

public class CodeUpdateResult {
    public String getId() {
        return id;
    }

    private final String id;

    public CodeUpdateResult(int id) {
        this.id = Integer.toString(id);
    }
}
