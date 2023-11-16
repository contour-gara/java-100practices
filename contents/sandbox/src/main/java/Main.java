import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Command<Date> dateCommand = CommandFactory.getInstance().createCurrentDateCommand();
        dateCommand.execute();

        System.out.println(dateCommand.getResult());
    }
}
