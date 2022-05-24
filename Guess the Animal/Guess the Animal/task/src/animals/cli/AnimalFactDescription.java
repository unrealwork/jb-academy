package animals.cli;

import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.composer.Composer;

import java.text.MessageFormat;

public class AnimalFactDescription extends CliMessage {
    private final MessageFormat contentTemplate;

    private final Fact fact;
    private final Subject animal1;
    private final Subject animal2;
    private final boolean isAboutSecond;

    public AnimalFactDescription(MessageFormat contentTemplate, Fact fact, Subject animal1, Subject animal2, boolean isAboutSecond) {
        this.contentTemplate = contentTemplate;
        this.fact = fact;
        this.animal1 = animal1;
        this.animal2 = animal2;
        this.isAboutSecond = isAboutSecond;
    }


    @Override
    public String content() {

        final String factAboutFirst = Composer.about(fact, animal1, !isAboutSecond)
                .asText();
        final String factAboutSecond = Composer.about(fact, animal2, isAboutSecond)
                .asText();

        final String question = Composer.question(fact)
                .asText();
        return contentTemplate.format(new Object[] {factAboutFirst, factAboutSecond, question});
    }
}
