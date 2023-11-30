package preparation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class VersionTest {
    @Test
    void 文字列表現がバージョンを表す() {
        // setup
        Version sut = new Version(1, 4, 2);

        // execute
        String actual = sut.toString();

        // assert
        String expected = "1.4.2";

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("createData")
    void オブジェクトの比較ができる(Version sut2, boolean expected) {
        // setup
        Version sut1 = new Version(1, 4, 2);

        // execute
        boolean actual = sut1.equals(sut2);

        // assert
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createData() {
        return Stream.of(
                arguments(new Version(2, 1, 0), false),
                arguments(new Version(1, 4, 2), true)
        );
    }

    @Test
    void majorのガード条件() {
        // assert
        assertThatThrownBy(() -> new Version(-1, 0, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("majorは0以上の数です。");
    }

    @Test
    void minorのガード条件() {
        // assert
        assertThatThrownBy(() -> new Version(0, -1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("minorは0以上の数です。");
    }

    @Test
    void patchのガード条件() {
        // assert
        assertThatThrownBy(() -> new Version(0, 0, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("patchは0以上の数です。");
    }

    @Test
    void 大小比較1() {
        // setup
        Version sut1 = new Version(1, 3, 9);
        Version sut2 = new Version(1, 4, 2);

        // assert
        assertThat(sut1).isLessThan(sut2);
    }

    @Test
    void 大小比較2() {
        // setup
        Version sut1 = new Version(10, 3, 5);
        Version sut2 = new Version(2, 23, 1);

        // assert
        assertThat(sut1).isGreaterThan(sut2);
    }

    @Test
    void メジャーアップデートができる() {
        // setup
        Version sut = new Version(1, 0, 0);

        // execute
        Version actual = sut.majorUpdate();

        // assert
        Version expected = new Version(2, 0, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void マイナーアップデートができる() {
        // setup
        Version sut = new Version(1, 0, 0);

        // execute
        Version actual = sut.minotUpdate();

        // assert
        Version expected = new Version(1, 1, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void パッチアップデートができる() {
        // setup
        Version sut = new Version(1, 0, 0);

        // execute
        Version actual = sut.patchUpdate();

        // assert
        Version expected = new Version(1, 0, 1);

        assertThat(actual).isEqualTo(expected);
    }
}
