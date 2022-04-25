package animals.cli;

import animals.Expression;
import animals.Fact;
import animals.IllegalExpression;

public class FactRequest implements Action<Fact> {
    private final Question<String> question;
    private final Message confirmationMessage;
    private final ActionFactory actionFactory;

    public FactRequest(ActionFactory actionFactory,
                       String question, String confirmationMessage) {
        this.actionFactory = actionFactory;
        this.question = actionFactory.question(question);
        this.confirmationMessage = actionFactory.message(confirmationMessage);
    }

    @Override
    public Fact execute() {
        String res = question.execute();
        
        Fact fact = readFact();
        while (fact == null) {
            confirmationMessage.execute();
            fact = readFact();
        }
        return fact;
    }

    private Fact readFact() {
        try {
            Expression expression = Expression.parse(res);
            return Fact.fromExpression(expression);
        } catch (IllegalExpression e) {
            return null;
        }
    }
}
