package myanswer01;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static com.opencsv.ICSVWriter.NO_QUOTE_CHARACTER;

public final class WriteCsv {
    private WriteCsv() {
    }

    public static void writeCsv(String path, Map<String, Double> map) {
        try (
                ICSVWriter writer = new CSVWriterBuilder(new FileWriter(path))
                        .withQuoteChar(NO_QUOTE_CHARACTER)
                        .build()
        ) {
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                writer.writeNext(new String[]{entry.getKey(), entry.getValue().toString()});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
