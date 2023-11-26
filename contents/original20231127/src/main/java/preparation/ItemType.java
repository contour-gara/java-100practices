package preparation;

import lombok.Getter;

@Getter
public enum ItemType {
    FOOD("food", true),
    DRINK("drink", true),
    ALCOHOL("alcohol", false),
    DRUG("drug", false),
    QUASI_DRUG("quasi_drug", false);

    private final String name;
    private final boolean isReduceTaxRate;

    ItemType(String name, boolean isReduceTaxRate) {
        this.name = name;
        this.isReduceTaxRate = isReduceTaxRate;
    }

    public static ItemType of(String name) {
        for (ItemType itemType : values()) {
            if (itemType.getName().equals(name)) return itemType;
        }
        throw new IllegalArgumentException("該当する商品種別が存在しません。");
    }
}
