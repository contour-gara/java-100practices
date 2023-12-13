package live;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsContainsFiveTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            5 | true
            6 | false
            """)
    void _5を含む場合(Integer num, Boolean expected) {
        // setup
        Rule sut = new IsContainsFive();

        // execute
        Boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
