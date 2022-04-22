package animals.cli;

import animals.ArticleType;
import animals.Expression;
import animals.Subject;
import animals.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalRequestAction implements Action<String> {
    private final ActionFactory actionFactory;

    public AnimalRequestAction(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    @Override
    public String execute() {
        final Action<String> animalQuestion = actionFactory.question("Enter an animal:");
        String res = animalQuestion.execute().toLowerCase();
        Expression animalExpression = Expression.parse(res);
        Subject subject = new Subject(animalExpression);
        String question = buildQuestion(subject);
        final Action<Boolean> confirmation = actionFactory.confirmation(actionFactory.message(question));
        Boolean confirm = confirmation.execute();
        while (confirm == null) {
            confirm = confirmation.execute();
        }
        final Message resMessage = actionFactory.message("You answered: " + (confirm ? "Yes" : "No"));
        resMessage.execute();
        return confirm ? res : null;
    }

    private String buildQuestion(final Subject subject) {
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList("Is", "it"));
        if (!subject.hasArticle()) {
            words.add(subject.getArticleType().content());
        }

        if (subject.hasArticle() && subject.getArticleType().isDefinite()) {
            Expression word = subject.withoutArticle();
            words.add(ArticleType.forExpression(word).content());
            word.tokens().stream()
                    .map(Token::content)
                    .forEach(words::add);
        } else {
            subject.tokens().stream()
                    .map(Token::content)
                    .forEach(words::add);
        }
        return String.join(" ", words) + "?";
    }
}
