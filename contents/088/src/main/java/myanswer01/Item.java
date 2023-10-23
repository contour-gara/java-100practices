package myanswer01;

import static java.util.Objects.isNull;

public record Item(Integer id, String name, String description) {
    public Item {
        if (isNull(id)) throw new IllegalArgumentException("idはNullを許可していません。");
        if (isNull(name)) throw new IllegalArgumentException("nameはNullを許可していません。");
        if (name.length() > 20) throw new IllegalArgumentException("nameは20文字以下です。");
    }
}
