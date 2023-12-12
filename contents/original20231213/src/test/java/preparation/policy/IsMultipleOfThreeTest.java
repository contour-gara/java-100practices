package preparation.policy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsMultipleOfThreeTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            3 | true
            4 | false
            5 | false
            6 | true
            """)
    void ＿3の倍数の場合tureを返す(Integer num, boolean expected) {
        // setup
        Rule sut = new IsMultipleOfThree();

        // execute
        boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
