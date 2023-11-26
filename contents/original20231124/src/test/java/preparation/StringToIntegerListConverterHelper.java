package preparation;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.TypedArgumentConverter;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

@SuppressWarnings("rawtypes")
public class StringToIntegerListConverterHelper extends TypedArgumentConverter<String, List> {
    protected StringToIntegerListConverterHelper() {
        super(String.class, List.class);
    }

    @Override
    protected List convert(String source) throws ArgumentConversionException {
        if (isNull(source)) return null;
        if (source.isEmpty()) return List.of();
        return Arrays.stream(source.split(", ")).map(Integer::valueOf).toList();
    }
}
