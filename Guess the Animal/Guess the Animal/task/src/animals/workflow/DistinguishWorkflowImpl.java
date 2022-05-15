package animals.workflow;

import animals.cli.Action;
import animals.cli.ActionFactory;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.storage.FactStorage;
import animals.storage.MessageKeys;
import animals.storage.MessageStorage;

import static animals.storage.MessageKeys.FACT_TEMPLATE;

public class DistinguishWorkflowImpl implements DistinguishWorkflow {
    private final ActionFactory actionFactory;
    private final MessageStorage storage;

    private final Subject animal1;

    private final Subject animal2;

    public DistinguishWorkflowImpl(ActionFactory factory, MessageStorage messageStorage, Subject animal1, Subject animal2) {
        this.actionFactory = factory;
        this.storage = messageStorage;
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    @Override
    public Fact flow() {
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
        return fact;
    }
}
