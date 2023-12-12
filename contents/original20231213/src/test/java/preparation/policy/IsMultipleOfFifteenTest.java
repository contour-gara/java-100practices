package preparation.policy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsMultipleOfFifteenTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            14 | false
            15 | true
            16 | false
            30 | true
            """)
    void _15の倍数の場合trueを返す(Integer num, boolean expected) {
        // setup
        Rule sut = new IsMultipleOfFifteen();

        // execute
        boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
