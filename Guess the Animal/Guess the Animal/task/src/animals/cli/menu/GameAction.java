package animals.cli.menu;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Question;
import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.lang.Token;
import animals.lang.composer.Composer;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;
import animals.tree.FileFormat;
import animals.tree.TreeLoader;
import animals.tree.TreeNode;

import java.util.List;

import static java.lang.Boolean.TRUE;

class GameAction implements Action<Void> {
    private final ActionFactory actionFactory;
    private final MessageStorage storage;
    private final TreeNode<Fact> tree;
    private final FileFormat format;

    public GameAction(ActionFactory actionFactory,
                      MessageStorage storage, TreeNode<Fact> tree, FileFormat format) {
        this.actionFactory = actionFactory;
        this.storage = storage;
        this.tree = tree;
        this.format = format;
    }

    @Override
    public Void execute() {
        final Action<Boolean> finishGameConfirmation = actionFactory.confirmation(storage.find(MessageKeys.PLAY_AGAIN));
        final Question<String> gameIntro = actionFactory.question(storage.find(MessageKeys.GAME_INTRO));
        do {
            gameIntro.execute();
            TreeNode<Fact> terminalNode = actionFactory.guessGame(tree)
                    .execute();
            Action<Boolean> finalQuestion = actionFactory.confirmation(Composer.question(terminalNode.val()).asText());
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
        TreeLoader.save(tree, format);
        return null;
    }

    private static Subject factToSubject(Fact fact) {
        List<Token> factTokens = fact.exp().tokens();
        Expression subExpression = Expression.fromTokens(
                factTokens.subList(2, factTokens.size())
        );
        return new Subject(subExpression);
    }
}
