package preparation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerTest {
    @ParameterizedTest
    @MethodSource("createData")
    void 受け入れ条件を満たす_MethodSourceで(Integer number, List<Integer> expected) {
        // setup
        Answer sut = new Answer();

        // execute
        List<Integer> actual = sut.execute(number);

        // assert
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(2, List.of(0, 1, 1)),
                Arguments.of(5, List.of(0, 1, 1, 2, 1, 2))
        );
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            2 | 0, 1, 1
            5 | 0, 1, 1, 2, 1, 2
            """)
    void 受け入れ条件を満たす_CsvSourceで(
            Integer number,
            @ConvertWith(StringToIntegerListConverterHelper.class) List<Integer> expected
    ) {
        // setup
        Answer sut = new Answer();

        // execute
        List<Integer> actual = sut.execute(number);

        // assert
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            2 | 0, 1, 1
            5 | 0, 1, 1, 2, 1, 2
            """)
    void 受け入れ条件を満たす_CsvSourceでかつ汎用的なクラスで(
            Integer number,
            @ConvertWith(StringToListConverterHelper.class) List<Integer> expected
    ) {
        // setup
        Answer sut = new Answer();

        // execute
        List<Integer> actual = sut.execute(number);

        // assert
        assertThat(actual).containsExactlyElementsOf(expected);
    }

}
