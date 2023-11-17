package myanswer02;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Command<Date> command = CommandFactory.getInstance().createCurrentDateCommand();

        System.out.println(command.getStatus());

        command.execute();

        System.out.println(command.getStatus());
        System.out.println(command.getResult());
    }
}
