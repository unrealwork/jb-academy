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

            final Action<Fact> factRequest = actionFactory.factRequest(storage.template(FACT_TEMPLATE, animal1.asText(), animal2.asText()), storage.find(MessageKeys.FACT_CONFIRM));
            factRequest.execute();
            actionFactory.lineBreak().execute();
            actionFactory.byeMessage().execute();
        }
    }
}
