package preparation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzUseCaseTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
             1 | '1: '
             2 | '2: '
             3 | '3: Fizz'
             5 | '5: Buzz'
            13 | '13: Fizz'
            15 | '15: FizzBuzz'
            51 | '51: Buzz'
            """)
    void FizzBuzzを適用し返す(Integer num, String expected) {
        // setup
        FizzBuzzUseCase sut = new FizzBuzzUseCase();

        // execute
        String actual = sut.execute(num);

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
