package animals.cli;

public interface ActionFactory extends AutoCloseable {

    Question<String> question(String question);

    Action<Boolean> confirmation(Message startQuestion);

    static ActionFactory cli() {
        return new ActionFactoryImpl();
    }

    Message greetingMessage();

    Message message(String s);

    Action<String> animalRequest();

    Message randomMessage(String... messages);

    Message lineBreak();

    default Message byeMessage() {
        return randomMessage("Have a nice day!",
                "See you soon!",
                "Bye!");
    }
}
