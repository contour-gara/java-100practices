package preparation;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(String suitString, String rankString) {
        suit = Suit.of(suitString);
        rank = Rank.of(rankString);
    }

    public String getNotation() {
        return rank.getValue() + suit.getValue();
    }
}
