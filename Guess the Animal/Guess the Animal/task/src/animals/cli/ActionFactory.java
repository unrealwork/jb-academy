package animals.cli;

import animals.lang.Fact;
import animals.lang.Subject;

public interface ActionFactory extends AutoCloseable {

    Question<String> question(String question);

    Action<Boolean> confirmation(Message startQuestion);

    Question<Subject> subjectQuestion(String s);

    static ActionFactory cli() {
        return new ActionFactoryImpl();
    }

    Message greetingMessage();

    Message message(String s);

    Action<String> animalRequest();

    Message randomMessage(String... messages);

    Message lineBreak();

    Message byeMessage();

    Action<Fact> factRequest(String question, String confirmationMessage);

    Action<Boolean> predicateQuestion(String question);

    public Message animalFactDescription(Fact fact, Subject animal1, Subject animal2, boolean isAboutSecond);

    default Action<Boolean> confirmation(String correctQuestion) {
        return confirmation(message(correctQuestion));
    }
}
