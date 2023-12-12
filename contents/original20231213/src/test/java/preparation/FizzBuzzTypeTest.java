package preparation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FizzBuzzTypeTest {
    @ParameterizedTest
    @MethodSource("createData")
    void それぞれの型を実行した場合(FizzBuzzType type, String expected) {
        // execute
        String actual = type.execute();

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                arguments(FizzBuzzType.FIZZ, "Fizz"),
                arguments(FizzBuzzType.BUZZ, "Buzz"),
                arguments(FizzBuzzType.FIZZ_BUZZ, "FizzBuzz"),
                arguments(FizzBuzzType.NUMBER, "")
        );
    }
}
