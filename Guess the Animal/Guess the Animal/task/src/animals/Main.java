package animals;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Question;
import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Token;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.TreeNode;

import java.util.List;

import static animals.storage.MessageKeys.FACT_TEMPLATE;
import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args) throws Exception {
        MessageStorage storage = MessageStorage.def();
        try (ActionFactory actionFactory = ActionFactory.cli()) {
            final Action<Void> greeting = actionFactory.greetingMessage();
            greeting.execute();
            actionFactory.lineBreak().execute();
            final Question<Subject> baseAnimalRequest = actionFactory.subjectQuestion(storage.find(MessageKeys.BASE_ANIMAL_REQUEST));
            final Subject baseAnimal = baseAnimalRequest.execute();
            TreeNode<Fact> tree = TreeNode.create(Fact.fromSubject(baseAnimal));
            final Action<Boolean> finishGameConfirmation = actionFactory.confirmation(storage.find(MessageKeys.PLAY_AGAIN));
            Question<String> gameIntro = actionFactory.question(storage.find(MessageKeys.GAME_INTRO));
            do {
                gameIntro.execute();
                TreeNode<Fact> terminalNode = actionFactory.guessGame(tree)
                        .execute();
                Action<Boolean> finalQuestion = actionFactory.confirmation(terminalNode.val().question().asText());
                boolean isGuessed = finalQuestion.execute();
                if (!isGuessed) {
                    final Action<Subject> newAnimalQuestion = actionFactory.subjectQuestion(storage.find(MessageKeys.NEW_ANIMAL));
                    Subject newAnimal = newAnimalQuestion.execute();
                    Subject lastAnimal = factToSubject(terminalNode.val());
                    Fact newFact = actionFactory.animalDiffRequest(lastAnimal, newAnimal)
                            .execute();
                    final String correctQuestion = storage.template(MessageKeys.FACT_CORRECT_QUESTION, newAnimal.asText().toLowerCase());
                    Action<Boolean> correctnessQuestion = actionFactory.predicateQuestion(correctQuestion);
                    final boolean isCorrect = correctnessQuestion.execute();
                    terminalNode.setVal(newFact);
                    terminalNode.setLeft(TreeNode.create(Fact.fromSubject(isCorrect ? lastAnimal : newAnimal)));
                    terminalNode.setRight(TreeNode.create(Fact.fromSubject(isCorrect ? newAnimal : lastAnimal)));
                    actionFactory.animalFactDescription(newFact, lastAnimal, newAnimal, isCorrect)
                            .execute();
                    actionFactory.message(storage.find(MessageKeys.NEW_KNOWLEDGE))
                            .execute();
                }
            } while (TRUE.equals(finishGameConfirmation.execute()));
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }

    private static Subject factToSubject(Fact fact) {
        List<Token> factTokens = fact.exp().tokens();
        Expression subExpression = Expression.fromTokens(
                factTokens.subList(2, factTokens.size())
        );
        return new Subject(subExpression);
    }

    private static void distinguishRequest(MessageStorage storage, ActionFactory actionFactory, Subject animal1, Subject animal2) {

    }
}
