package myanswer01;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Command<?>> commands = List.of(
                CommandFactory.getInstance().createCurrentDateCommand(),
                CommandFactory.getInstance().createRandomIntegerCommand()
        );

        for (Command<?> command : commands) {
            log.info(command.getStatus().toString());
            command.execute();
            log.info(command.getStatus().toString());
            log.info(command.getResult().toString());
        }
    }
}
