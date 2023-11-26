package preparation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTypeTest {
    @ParameterizedTest
    @MethodSource("createData")
    void ファクトリメソッドでインスタンスが生成できる(String name, ItemType expected) {
        // execute
        ItemType actual = ItemType.of(name);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of("food", ItemType.FOOD),
                Arguments.of("drink", ItemType.DRINK)
        );
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            null
            aiueo
            """)
    void ファクトリメソッドのエラー処理(String name) {
        // assert
        assertThatThrownBy(() -> ItemType.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("該当する商品種別が存在しません。");
    }

    @Test
    void 軽減税率かどうか() {
        // setup
        ItemType sut = ItemType.FOOD;

        // execute
        boolean actual = sut.isReduceTaxRate();

        // assert
        assertThat(actual).isTrue();
    }
}
