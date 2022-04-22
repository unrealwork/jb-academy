package animals.cli;

public class AnimalRequestAction implements Action<String> {
    private final ActionFactory actionFactory;

    public AnimalRequestAction(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    @Override
    public String execute() {
        final Action<String> animalQuestion = actionFactory.question("Enter an animal:");
        String res = animalQuestion.execute();
        final Action<Boolean> confirmation = actionFactory.confirmation();
        Boolean confirm = confirmation.execute();
        while (confirm == null) {
            confirm = confirmation.execute();
        }
        final Message resMessage = actionFactory.message("You answered: " + (confirm ? "Yes" : "No"));
        resMessage.execute();
        return confirm ? res : null;
    }
}
