package animals;

public enum FactType {
    IS("is", "isn't", "Is it"), HAS("has", "doesn't have", "Does it have"), CAN("can", "can't", "Can it");

    private final String content;
    private final String negation;
    private final String question;

    FactType(String can, String negation, String question) {
        this.content = can;
        this.negation = negation;
        this.question = question;
    }

    public String negation() {
        return negation;
    }

    public String question() {
        return question;
    }

    public String content() {
        return content;
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
