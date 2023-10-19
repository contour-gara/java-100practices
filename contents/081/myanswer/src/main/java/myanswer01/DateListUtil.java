package myanswer01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.isNull;

public final class DateListUtil {
    private DateListUtil() {
    }

    public static List<Date> shallowCopyDateList(List<Date> originalList) {
        if (isNull(originalList)) throw new IllegalArgumentException("対象の配列が存在しません。");
        return new ArrayList<>(originalList);
    }

    public static List<Date> deepCopyDateList(List<Date> originalList) {
        if (isNull(originalList)) throw new IllegalArgumentException("対象の配列が存在しません。");
        List<Date> result = new ArrayList<>();
        for (Date original : originalList) {
            if (original == null) {
                result.add(null);
            } else {
                result.add((Date) original.clone());
            }
        }
        return result;
    }
}
