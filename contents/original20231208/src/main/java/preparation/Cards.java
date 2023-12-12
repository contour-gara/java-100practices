package preparation;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final List<Card> cards = new ArrayList<>();

    public void drawCards(Card card) {
        cards.add(card);
    }
}
