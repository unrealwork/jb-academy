package animals;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Question;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.storage.FactStorage;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;

import static animals.storage.MessageKeys.FACT_TEMPLATE;

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
        
    }
}
