package myanswer01.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record Person(
        @Min(value = 0) Integer age,
        @NotNull String name
) {
}
