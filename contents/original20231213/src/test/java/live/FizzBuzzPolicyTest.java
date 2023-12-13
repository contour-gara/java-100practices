package live;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzPolicyTest {
    @Test
    void _3の場合Fizzを返す() {
        // setup
        FizzBuzzPolicy sut = new FizzBuzzPolicy();

        // execute
        String actual = sut.apply(3);

        // assert
        String expected = "3: Fizz";
        assertThat(actual).isEqualTo(expected);
    }
}
