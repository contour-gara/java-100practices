package preparation.policy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsContainFiveTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
            51
            52
            """)
    void _5が含まれる場合trueを返す(Integer num) {
        // setup
        Rule sut = new IsContainFive();

        // execute
        boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isTrue();
    }
}
