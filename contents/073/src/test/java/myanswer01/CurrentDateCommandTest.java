package myanswer01;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentDateCommandTest {
    @Test
    void 現在の日付を返す() {
        // setup
        CurrentDateCommand currentDateCommand = new CurrentDateCommand();

        // execute
        Date actual = currentDateCommand.executeInner();

        // assert
        Date expected = new Date();
        assertThat(actual).isEqualTo(expected);
    }
}
