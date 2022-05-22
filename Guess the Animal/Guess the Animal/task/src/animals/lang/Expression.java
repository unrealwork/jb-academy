package animals.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public interface Expression {

    default Token first() {
        return tokens().iterator().next();
    }

    List<Token> tokens();

    default String asText() {
        return tokens().stream()
                .map(Token::content)
                .collect(Collectors.joining(" "));
    }

    default Expression concat(Expression o) {
        List<Token> concatenatedTokens = new ArrayList<>();
        concatenatedTokens.addAll(tokens());
        concatenatedTokens.addAll(o.tokens());
        return ExpressionImpl.create(Collections.unmodifiableList(concatenatedTokens));
    }
    
    default Expression toLowerCase() {
        List<Token> tokens = tokens().stream().map(Token::toLowercase).collect(Collectors.toList());
        return fromTokens(tokens);
    }
    
    default boolean equalsIgnoreCase(Expression e) {
        List<Token> words = tokens();
        if (e == null) {
            return false;
        }
        if (words.size() != e.tokens().size()) {
            return false;
        }
        Iterator<Token> it1 = words.iterator();
        Iterator<Token> it2 = e.tokens().iterator();
        while (it1.hasNext() && it2.hasNext()) {
            Token t1 = it1.next();
            Token t2 = it2.next();
            if (!t1.content().equalsIgnoreCase(t2.content())) {
                return false;
            }
        }
        return true;
    }
    
    static Expression fromTokens(final List<Token> tokens) {
        return ExpressionImpl.create(tokens);
    }
    
    static Expression parse(String s) throws IllegalExpressionException {
        List<Token> tokens = new ArrayList<>();
        StringBuilder tokenBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isSentenceEnd(c) && i != (s.length() - 1)) {
                throw new IllegalExpressionException("Expression should contain only one terminal symbol");
            }
            if (Character.isLetterOrDigit(c)) {
                tokenBuilder.append(c);
            } else {
                int tokenLength = tokenBuilder.length();
                if (tokenLength > 0) {
                    tokens.add(new Word(tokenBuilder.toString(), i - tokenLength));
                }
                tokenBuilder.setLength(0);
            }
        }
        if (tokenBuilder.length() > 0) {
            tokens.add(new Word(tokenBuilder.toString(),
                    s.length() - tokenBuilder.length()));
        }
        return ExpressionImpl.create(Collections.unmodifiableList(tokens));
    }

    private static boolean isSentenceEnd(char c) {
        return c == '!' || c == '.';
    }
}
