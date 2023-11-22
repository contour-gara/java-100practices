package preparation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileEditorTest {
    FileEditor sut = new FileEditor();

    @Test
    void 逆順になる() {
        // execute
        List<String> actual = sut.reverseAndRemoveKanji(List.of(
                "ひらがな",
                "aiu",
                "123"
        ));

        // assert
        assertThat(actual).containsExactlyElementsOf(List.of(
                "123",
                "aiu",
                "ひらがな"
        ));
    }

    @Test
    void 漢字が入った文字列が除去される() {
        // execute
        List<String> actual = sut.reverseAndRemoveKanji(List.of(
                "ひらがな",
                "aiu",
                "123",
                "漢字"
        ));

        // assert
        assertThat(actual).containsExactlyElementsOf(List.of(
                "123",
                "aiu",
                "ひらがな"
        ));
    }
}
