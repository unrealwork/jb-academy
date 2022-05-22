package animals.cli;

class PredicateQuestion implements Action<Boolean> {
    private final Action<Boolean> confirmation;

    PredicateQuestion(ActionFactory factory, String question) {
        this.confirmation = factory.confirmationQuestion(question);
    }


    @Override
    public Boolean execute() {
        Boolean res = confirmation.execute();
        while (res == null) {
            res = confirmation.execute();
        }
        return res;
    }
}
