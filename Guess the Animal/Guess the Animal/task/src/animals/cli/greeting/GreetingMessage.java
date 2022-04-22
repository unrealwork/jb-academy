package animals.cli.greeting;

import animals.cli.CliMessage;

public class GreetingMessage extends CliMessage {


    @Override
    public String content() {
        return Greeting.fromLocalTime()
                .message();
    }
}
