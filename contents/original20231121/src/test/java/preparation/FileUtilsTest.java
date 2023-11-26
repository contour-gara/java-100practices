package preparation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileUtilsTest {
    private static final List<String> LIST = List.of("かんじなし", "漢字あり", "12345");

    @Test
    void ファイルが読める() {
        // execute
        List<String> actual
                = FileUtils.readFile("/Users/daisuke_garaike/git/java-100practices/contents/original1121/src/test/resources/"
                        + "test-input.txt");

        // assert
        assertThat(actual).isEqualTo(LIST);
    }

    @Test
    void ファイルが書き出しできる(@TempDir Path path) {
        // setup
        String fileName = path.resolve("test-output.txt").toString();

        // execute
        FileUtils.writeFile(fileName, LIST);

        // assert
        List<String> actual = FileUtils.readFile(fileName);
        assertThat(actual).containsExactlyElementsOf(LIST);
    }
}
