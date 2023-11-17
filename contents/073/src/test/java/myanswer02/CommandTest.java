package myanswer02;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {
    @Test
    void 現在日時を取得できる() {
        // setup
        Command<Date> sut = CommandFactory.getInstance().createCurrentDateCommand();

        // execute
        sut.execute();

        // assert
        Date actualResult = sut.getResult();
        assertThat(actualResult).isNotNull();

        Status actualStatus = sut.getStatus();
        assertThat(actualStatus).isEqualTo(Status.SUCCESS);
    }

    @Test
    void 乱数を取得できる() {
        // setup
        Command<Integer> sut = CommandFactory.getInstance().createRandomIntegerCommand();
    }
}
