package preparation;

import com.google.common.reflect.TypeToken;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class StringToListConverterHelper implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if ((nonNull(source)) && !(source instanceof String))
            throw new ArgumentConversionException("Source must be a string");
        if (!List.class.isAssignableFrom(context.getParameter().getType()))
            throw new ArgumentConversionException("Target must be a list");

        String sourceString = (String) source;

        if (isNull(sourceString)) return null;
        if (sourceString.isEmpty()) return List.of();

        Class<?> elementType = TypeToken.of(context.getParameter().getParameterizedType())
                .resolveType(List.class.getTypeParameters()[0])
                .getRawType();

        return Arrays.stream(sourceString.split(", "))
                .map(s -> DefaultArgumentConverter.INSTANCE.convert(s, elementType, context))
                .toList();
    }
}
