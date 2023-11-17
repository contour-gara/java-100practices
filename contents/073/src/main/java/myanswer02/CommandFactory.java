package myanswer02;

import java.util.Date;

public class CommandFactory {
    private static final CommandFactory C = new CommandFactory();

    private CommandFactory() {}

    public static CommandFactory getInstance() {
        return C;
    }

    public Command<Date> createCurrentDateCommand() {
        return new CurrentDateCommand();
    }

    public Command<Integer> createRandomIntegerCommand() {
        return new RandomIntegerCommand();
    }
}
