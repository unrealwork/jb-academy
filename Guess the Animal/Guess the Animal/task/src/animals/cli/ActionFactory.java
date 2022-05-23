package animals.cli;

import animals.cli.menu.MenuOption;
import animals.cli.menu.MenuService;
import animals.lang.Fact;
import animals.lang.Subject;
import animals.tree.TreeNode;

public interface ActionFactory extends AutoCloseable {

    Question<String> question(String question);

    Action<Boolean> confirmationQuestion(Message startQuestion);

    Question<Subject> subjectQuestion(String s);

    static ActionFactory cli() {
        return new ActionFactoryImpl();
    }

    Message greetingMessage();

    Message message(String s);

    Message randomMessage(String... messages);

    Message lineBreak();

    Message byeMessage();

    Action<Fact> factRequest(String question, String confirmationMessage);
    
    Action<Fact> animalDiffRequest(Subject firstAnimal, Subject secondAnimal);
    
    Action<Boolean> predicateQuestion(String question);

    Message animalFactDescription(Fact fact, Subject animal1, Subject animal2, boolean isAboutSecond);

    default Action<TreeNode<Fact>> guessGame(final TreeNode<Fact> tree) {
        return new GuessFlowAction(this, tree);
    }

    default Action<Boolean> confirmationQuestion(String correctQuestion) {
        return confirmationQuestion(message(correctQuestion));
    }

    default Action<Boolean> confirmation(String question) {
        return new Confirmation(this, question);
    }

    Action<MenuOption> menuAction(MenuService menuService);
}
