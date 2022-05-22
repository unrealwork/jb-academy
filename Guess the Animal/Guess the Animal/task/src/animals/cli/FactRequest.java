package animals.cli;

import animals.lang.Expression;
import animals.lang.Fact;
import animals.lang.IllegalExpressionException;

public class FactRequest implements Action<Fact> {
    private final Question<String> question;
    private final Message confirmationMessage;

    public FactRequest(ActionFactory actionFactory,
                       String question, String confirmationMessage) {
        this.question = actionFactory.question(question);
        this.confirmationMessage = actionFactory.message(confirmationMessage);
    }

    @Override
    public Fact execute() {
        String res = question.execute().toLowerCase();

        Fact fact = readFact(res);
        while (fact == null) {
            confirmationMessage.execute();
            fact = readFact(null);
        }
        return fact;
    }

    private Fact readFact(final String ans) {
        try {
            String res = ans == null ? question.execute().toLowerCase() : ans;
            Expression expression = Expression.parse(res);
            return Fact.fromExpression(expression);
        } catch (IllegalExpressionException e) {
            return null;
        }
    }
}
