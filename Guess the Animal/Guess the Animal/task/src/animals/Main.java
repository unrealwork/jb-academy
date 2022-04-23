package animals;

import animals.cli.Action;
import animals.cli.ActionFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        try (ActionFactory actionFactory = ActionFactory.cli()) {
            final Action<Void> greeting = actionFactory.greetingMessage();
            final Action<String> animalReq = actionFactory.animalRequest();
            greeting.execute();
            actionFactory.lineBreak().execute();
            animalReq.execute();
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }
}
