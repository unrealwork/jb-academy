package animals;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.cli.Question;

public class Main {
    public static void main(String[] args) throws Exception {

        try (ActionFactory actionFactory = ActionFactory.cli()) {
            final Action<Void> greeting = actionFactory.greetingMessage();
            final Question<Subject> animal1Req = actionFactory.subjectQuestion("Enter the first animal:");
            final Question<Subject> animal2Req = actionFactory.subjectQuestion("Enter the second animal:");
            greeting.execute();
            actionFactory.lineBreak().execute(); 
            animalReq.execute();
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }
}
