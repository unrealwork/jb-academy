package animals;

public interface Token {

    static Token EMPTY = new Word("", -1);

    int pos();

    int length();

    String content();

}
