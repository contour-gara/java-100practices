package preparation;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateTotalAmountUseCaseTest {
    @ParameterizedTest
    @MethodSource("createData")
    void 受け入れ条件を満たす(List<Pair<Item, Integer>> inputs, Integer expected) {
        // setup
        CalculateTotalAmountUseCase sut = new CalculateTotalAmountUseCase();

        // execute
        Integer actual = sut.execute(inputs);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Pair.of(new Item("鮭おにぎり", 139, ItemType.of("food")), 2),
                                Pair.of(new Item("氷結", 141, ItemType.of("alcohol")), 3)
                        ),
                        765
                ),
                Arguments.of(
                        List.of(
                                Pair.of(new Item("大きなおむすび", 186, ItemType.of("food")), 3),
                                Pair.of(new Item("午後の紅茶", 140, ItemType.of("drink")), 4),
                                Pair.of(new Item("新ルルＡ錠ｓ50 錠", 871, ItemType.of("drug")), 1)
                        ),
                        2162
                )
        );
    }
}
