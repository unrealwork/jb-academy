package animals.cli;

import animals.Fact;
import animals.Subject;

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
}
