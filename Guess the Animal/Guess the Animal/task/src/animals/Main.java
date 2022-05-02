package animals;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Question;

import static animals.MessageKeys.FACT_TEMPLATE;

public class Main {
    public static void main(String[] args) throws Exception {
        MessageStorage storage = MessageStorage.def();
        try (ActionFactory actionFactory = ActionFactory.cli()) {
            final Action<Void> greeting = actionFactory.greetingMessage();
            final Question<Subject> animal1Req = actionFactory.subjectQuestion("Enter the first animal:");
            final Question<Subject> animal2Req = actionFactory.subjectQuestion("Enter the second animal:");
            greeting.execute();
            actionFactory.lineBreak().execute();
            final Subject animal1 = animal1Req.execute();
            final Subject animal2 = animal2Req.execute();

            final String question = storage.template(FACT_TEMPLATE, animal1.asText().toLowerCase(), animal2.asText().toLowerCase());
            final String confirmationMessage = storage.find(MessageKeys.FACT_CONFIRM);
            final Action<Fact> factRequest = actionFactory.factRequest(question, confirmationMessage);
            final Fact fact = factRequest.execute();
            final String correctQuestion = storage.template(MessageKeys.FACT_CORRECT_QUESTION, animal2.asText().toLowerCase());
            Action<Boolean> correctnessQuestion = actionFactory.predicateQuestion(correctQuestion);
            final Boolean isCorrect = correctnessQuestion.execute();
            FactStorage factStorage = FactStorage.create();
            factStorage.add(fact, isCorrect ? animal2 : animal1);
            actionFactory.animalFactDescription(fact, animal1, animal2, isCorrect)
                    .execute();
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }
}
