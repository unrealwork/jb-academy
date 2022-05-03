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
            greeting.execute();
            actionFactory.lineBreak().execute();
            final Question<Subject> baseAnimalRequest = actionFactory.subjectQuestion(storage.find(MessageKeys.BASE_ANIMAL_REQUEST));
            final Subject baseAnimal = baseAnimalRequest.execute();
            actionFactory.question(storage.find(MessageKeys.GAME_INTRO))
                    .execute();
            
//            distinguishRequest(storage, actionFactory, animal1, animal2);
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }

    private static void distinguishRequest(MessageStorage storage, ActionFactory actionFactory, Subject animal1, Subject animal2) {
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
    }
}
