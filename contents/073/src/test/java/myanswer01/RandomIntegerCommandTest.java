package myanswer01;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomIntegerCommandTest {
    @Test
    void ランダムな数値を返す() {
        // setup
        RandomIntegerCommand randomIntegerCommand = new RandomIntegerCommand(2023);

        // execute
        Integer actual = randomIntegerCommand.executeInner();

        // assertion
        Integer expected = new Random(2023).nextInt();
        assertThat(actual).isEqualTo(expected);
    }
}
