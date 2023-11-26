package preparation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ItemTest {
    @Test
    void nameがnullであってはならない() {
        // assert
        assertThatThrownBy(() -> new Item(null, 100, ItemType.FOOD))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("nameはnullであってはなりません。");
    }

    @Test
    void priceWithoutTaxがnullであってはならない() {
        // assert
        assertThatThrownBy(() -> new Item("name", null, ItemType.FOOD))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("priceWithoutTaxはnullであってはなりません。");
    }

    @Test
    void ItemTypeがnullであってはならない() {
        // assert
        assertThatThrownBy(() -> new Item("name", 100, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("itemTypeはnullであってはなりません。");
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            drink | 101 | 109
            drug  | 321 | 353
            """)
    void 消費税込みの金額を返す(String itemType, Integer priceWithoutTax, Integer expected) {
        // setup
        Item sut = new Item("test", priceWithoutTax, ItemType.of(itemType));

        // execute
        Integer actual = sut.getPriceWithTax();

        // assert
        assertThat(actual).isEqualTo(expected);
    }
}
