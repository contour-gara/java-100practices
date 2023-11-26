package preparation;

import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item, Integer quantity){
        for (int i = 1; i <= quantity; ++i) {
            items.add(item);
        }
    }

    public Integer calculateTotalAmount() {
        int result = 0;
        for (Item item : items) {
            result += item.getPriceWithTax();
        }
        return result;
    }
}
