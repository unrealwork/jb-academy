import java.util.Scanner;

interface Command {
    void execute();
    /* write your code here */
}

public class Main {
    public static void main(String[] args) {
        int[] amountList = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            amountList[i] = scanner.nextInt();
        }

        Broker broker = new Broker();
        for (int i = 0; i < 3; i++) {
            Option option = new Option(amountList[i]);
            Command command;
            if (amountList[i] > 0) {
                /* write your code here */
                command = new BuyCommand(option);
            } else {
                /* write your code here */
                command = new SellCommand(option);
            }
            broker.setCommand(command);
            broker.executeCommand();
        }
    }
}

class Option {
    private int amount;

    Option(int amount) {
        this.amount = amount;
    }

    void buy() {
        System.out.println(amount + " was bought");
    }

    void sell() {
        /* write your code here */
        System.out.printf("%d was sold%n", amount);
    }
}

class BuyCommand implements Command {
    private Option option;

    BuyCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.buy();
    }

    /* write your code here */
}

class SellCommand implements Command {
    private Option option;

    SellCommand(Option option) {
        this.option = option;
    }

    @Override
    public void execute() {
        option.sell();
    }

    /* write your code here */
}

class Broker {
    private Command command;

    void setCommand(Command command) {
        /* write your code here */
        this.command = command;
    }

    void executeCommand() {
        /* write your code here */
        command.execute();
    }
}
