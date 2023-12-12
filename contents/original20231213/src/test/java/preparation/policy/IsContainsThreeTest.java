package preparation.policy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsContainsThreeTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
            13
            23
            """)
    void _3が含まれる場合trueを返す(Integer num) {
        // setup
        Rule sut = new IsContainsThree();

        // execute
        boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isTrue();
    }
}
