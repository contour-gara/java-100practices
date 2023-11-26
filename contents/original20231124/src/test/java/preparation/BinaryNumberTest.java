package preparation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryNumberTest {
    @Test
    void インスタンス変数を取得できる() {
        // setup
        BinaryNumber sut = new BinaryNumber(3);

        // execute
        Integer actual = sut.number();

        // assert
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            3 | 2
            4 | 1
            5 | 2
            """)
    void _2進数に変換した時の1の数を出力できる(Integer number, Integer numberOfOne) {
        // setup
        BinaryNumber sut = new BinaryNumber(number);

        // execute
        Integer actual = sut.countNumberOfOneInBinary();

        // assert
        assertThat(actual).isEqualTo(numberOfOne);
    }
}
