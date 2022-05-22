package animals.lang;

public class Word implements Token {

    private final int pos;
    private final int len;
    private final String content;

    Word(String s, int pos) {
        this.pos = pos;
        this.len = s.length();
        this.content = s;
    }
    
    @Override
    public int pos() {
        return pos;
    }

    @Override
    public int length() {
        return len;
    }

    @Override
    public String content() {
        return content;
    }
}
