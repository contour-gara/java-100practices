package live;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class IsContainsThreeTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
             3 | true
            13 | true
            14 | false
            """)
    void _3が含まれている場合(Integer num, Boolean expected) {
        // setup
        Rule sut = new IsContainsThree();

        // execute
        Boolean actual = sut.ok(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
