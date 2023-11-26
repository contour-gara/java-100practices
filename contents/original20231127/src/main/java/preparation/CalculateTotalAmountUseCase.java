package preparation;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class CalculateTotalAmountUseCase {
    public Integer execute(List<Pair<Item, Integer>> inputs) {
        Cart cart = new Cart();

        for (Pair<Item, Integer> pair : inputs) {
            cart.add(pair.getLeft(), pair.getRight());
        }

        return cart.calculateTotalAmount();
    }
}
