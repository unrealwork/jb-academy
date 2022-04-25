package animals;

public enum FactType {
    IS("is"), HAS("has"), CAN("can");

    private final String content;

    FactType(String can) {
        this.content = can;
    }

    public static FactType fromToken(Token token) {
        for (FactType value : values()) {
            if (value.content.equalsIgnoreCase(token.content())) {
                return value;
            }
        }
        return null;
    }
}
