package animals.cli;

class Confirmation implements Action<Boolean> {
    private final Action<Boolean> confirmationQuestion;

    public Confirmation(ActionFactory actionFactory, String question) {
        this.confirmationQuestion = actionFactory.confirmationQuestion(question);
    }

    @Override
    public Boolean execute() {
        Boolean isConfirmed = confirmationQuestion.execute();
        while (isConfirmed == null) {
            isConfirmed = confirmationQuestion.execute();
        }
        return isConfirmed;
    }
}
