package ExAnswer01;

import com.google.common.collect.Streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 応用。
 */
public class Main {
    /**
     * メインメソッド。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        Path input = Path.of("./contents/055/src/main/resources/MyAnswer055.txt");
        Path output = Path.of("./contents/055/src/main/resources/exoutput055.txt");

        try (
                BufferedReader reader = Files.newBufferedReader(input, UTF_8);
                BufferedWriter writer = Files.newBufferedWriter(output, UTF_8)
        ) {
            Streams.mapWithIndex(
                            reader.lines(),
                            (str, idx) -> String.format("%s %s%n", idx + 1, str)
                    )
                    .forEach(i -> write(writer, i));
        } catch (IOException | UncheckedIOException e) {
            e.printStackTrace();
        }
    }

    private static void write(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
