package myanswer01;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (MyException e) {
            String stackTrace = getStackTrace(e);
            stackTrace = stackTrace.replace("\n", "\\\\\\n");
            writeFile(stackTrace);
        }
    }

    private static void throwException() {
        throw new MyException("Exception!!!");
    }

    private static void writeFile(String stacktrace) {
        try (
                BufferedWriter writer = Files.newBufferedWriter(
                        Path.of("./contents/087/src/main/resources/stacktrace.txt")
                )
        ) {
            writer.write(stacktrace);
            writer.newLine();
        } catch (IOException e) {
            log.warn("", e);
        }
    }
}
