package preparation;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {
    @Test
    void カートに商品を追加できる() {
        // setup
        Cart sut = new Cart();
        Item item = new Item("test", 100, ItemType.of("drink"));
        Integer quantity = 2;

        // execute
        sut.add(item , quantity);

        // assert
        assertThat(sut.getItems()).containsExactly(item, item);
    }

    @Test
    void カートの合計金額を計算できる() {
        // setup
        Cart sut = new Cart();
        Item item1 = new Item("test", 100, ItemType.of("drink"));
        Item item2 = new Item("test", 100, ItemType.of("drug"));
        sut.add(item1, 1);
        sut.add(item2, 2);

        // execute
        Integer actual = sut.calculateTotalAmount();

        // assert
        Integer expected = 328;
        assertThat(actual).isEqualTo(expected);
    }
}
