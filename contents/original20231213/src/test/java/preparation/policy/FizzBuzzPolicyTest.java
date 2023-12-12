package preparation.policy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import preparation.FizzBuzzType;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzPolicyTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
            15
            30
            """)
    void _15の倍数の場合(Integer num) {
        // setup
        FizzBuzzPolicy sut = new FizzBuzzPolicy();

        // execute
        FizzBuzzType actual = sut.apply(num);

        // assert
        FizzBuzzType expected = FizzBuzzType.FIZZ_BUZZ;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            5
            25
            51
            52
            """)
    void _5の倍数または5が含まれる場合(Integer num) {
        // setup
        FizzBuzzPolicy sut = new FizzBuzzPolicy();

        // execute
        FizzBuzzType actual = sut.apply(num);

        // assert
        FizzBuzzType expected = FizzBuzzType.BUZZ;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            3
            23
            24
            43
            """)
    void _3の倍数または3が含まれる場合(Integer num) {
        // setup
        FizzBuzzPolicy sut = new FizzBuzzPolicy();

        // execute
        FizzBuzzType actual = sut.apply(num);

        // assert
        FizzBuzzType expected = FizzBuzzType.FIZZ;
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            1
            2
            4
            14            
            """)
    void どのルールにもあたらない場合(Integer num) {
        // setup
        FizzBuzzPolicy sut = new FizzBuzzPolicy();

        // execute
        FizzBuzzType actual = sut.apply(num);

        // assert
        FizzBuzzType expected = FizzBuzzType.NUMBER;
        assertThat(actual).isEqualTo(expected);
    }
}
