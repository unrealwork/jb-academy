package animals.cli;

import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Template;
import animals.lang.Token;

import java.util.ArrayList;
import java.util.List;

public class AnimalFactDescription extends CliMessage {
    private final Template contentTemplate;

    private final Fact fact;
    private final Subject animal1;
    private final Subject animal2;
    private final boolean isAboutSecond;

    public AnimalFactDescription(Template contentTemplate, Fact fact, Subject animal1, Subject animal2, boolean isAboutSecond) {
        this.contentTemplate = contentTemplate;
        this.fact = fact;
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.isAboutSecond = isAboutSecond;
    }


    @Override
    public String content() {
        final List<Token> tokenList = new ArrayList<>();
        final String factAboutFirst = fact.about(animal1, !isAboutSecond)
                .asText();
        final String factAboutSecond = fact.about(animal2, isAboutSecond)
                .asText();

        final String question = fact.question().asText();
        return contentTemplate.format(factAboutFirst, factAboutSecond, question);
    }
}
