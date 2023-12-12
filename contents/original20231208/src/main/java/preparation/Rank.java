package preparation;

import lombok.Getter;

@Getter
public enum Rank {
    ACE("A"),
    DUCE("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NIGHT("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private final String value;

    Rank(String value) {
        this.value = value;
    }

    public static Rank of(String value) {
        for (Rank rank : values()) {
            if (rank.getValue().equals(value)) return rank;
        }

        throw new IllegalArgumentException("該当するランクが存在しません。");
    }
}
