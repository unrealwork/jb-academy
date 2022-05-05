package animals.lang;

public interface Token {

    static Token EMPTY = new Word("", -1);

    int pos();

    int length();

    String content();

    default Token toLowercase() {
        return word(content().toLowerCase());
    }

    static Token word(String s) {
        return new Word(s, -1);
    }

}
