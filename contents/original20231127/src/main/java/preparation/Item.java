package preparation;

import static java.util.Objects.isNull;

public record Item(String name, Integer priceWithoutTax, ItemType itemType) {
    public Item {
        if (isNull(name)) throw new IllegalArgumentException("nameはnullであってはなりません。");
        if (isNull(priceWithoutTax)) throw new IllegalArgumentException("priceWithoutTaxはnullであってはなりません。");
        if (isNull(itemType)) throw new IllegalArgumentException("itemTypeはnullであってはなりません。");
    }

    public Integer getPriceWithTax() {
        if (itemType.isReduceTaxRate()) return (int) Math.floor(priceWithoutTax * 1.08);
        return (int) Math.floor(priceWithoutTax * 1.1);
    }
}
