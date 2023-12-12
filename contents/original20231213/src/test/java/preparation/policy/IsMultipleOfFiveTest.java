package preparation.policy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsMultipleOfFiveTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            5 | true
            4 | false
            6 | false
            10 | true
            """)
    void ＿5の倍数の場合tureを返す(Integer num, boolean expected) {
        // setup
        Rule sut = new IsMultipleOfFive();

        // execute
        boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
