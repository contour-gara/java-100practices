package preparation;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public final class FileUtils {
    private static final String ERROR_MESSAGE = "ファイル入出力エラーが発生しました。";

    private FileUtils() {}

    public static List<String> readFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName), UTF_8)) {
            return reader.lines().toList();
        } catch (IOException e) {
            log.warn(ERROR_MESSAGE, e);
        }
        return new ArrayList<>();    }

    public static void writeFile(String fileName, List<String> lines) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            lines.forEach(line -> write(writer, line));
        } catch (IOException e) {
            log.warn(ERROR_MESSAGE, e);
        }
    }

    private static void write(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            log.warn(ERROR_MESSAGE, e);
        }
    }
}
