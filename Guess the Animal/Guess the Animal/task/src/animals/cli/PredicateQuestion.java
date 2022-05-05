package animals.cli;

import animals.storage.MessageStorage;

class PredicateQuestion implements Action<Boolean> {
    private final Action<Boolean> confirmation;

    PredicateQuestion(ActionFactory factory, MessageStorage storage, String question) {
        this.confirmation = factory.confirmation(question);
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
