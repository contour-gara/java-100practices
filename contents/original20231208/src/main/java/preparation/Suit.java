package preparation;

import lombok.Getter;

@Getter
public enum Suit {
    SPADE("♠"),
    HEART("♥"),
    CLUB("♣"),
    DIAMOND("♦");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    public static Suit of(String value) {
        for (Suit suit : Suit.values()) {
            if (suit.getValue().equals(value)) return suit;
        }

        throw new IllegalArgumentException("該当するスートが存在しません。");
    }
}
