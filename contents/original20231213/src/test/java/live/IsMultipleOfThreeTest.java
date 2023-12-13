package live;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsMultipleOfThreeTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            3 | true
            6 | true
            4 | false
            """)
    void _3の倍数の場合true(Integer num, Boolean expected) {
        // setup
        Rule sut = new IsMultipleOfThree();

        // execute
        Boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
