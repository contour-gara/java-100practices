package myanswer01;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ReadExcel {
    private ReadExcel() {
    }

    public static Map<String, Double> readExcel(String path) {
        try (
                Workbook workbook = WorkbookFactory.create(
                        new File(path)
                )
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            return IntStream.rangeClosed(9, 55)
                    .mapToObj(sheet::getRow)
                    .collect(
                            Collectors.toMap(
                                    (Row row) -> row.getCell(0).getStringCellValue(),
                                    (Row row) -> row.getCell(6).getNumericCellValue(),
                                    (oldVal, newVal) -> newVal,
                                    LinkedHashMap::new
                            )
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
