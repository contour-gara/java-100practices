package myanswer01;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> prefectures = getPrefecture();
        List<Double> populations = getPopulation();
        createFile(prefectures, populations);
    }

    private static List<String> getPrefecture() {
        List<String> prefectures = new ArrayList<>();

        try (
                Workbook workbook = WorkbookFactory.create(new File("./contents/089/src/main/resources/n230200200.xlsx"))
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            IntStream.rangeClosed(9, 55)
                    .mapToObj(sheet::getRow)
                    .map(row -> row.getCell(0))
                    .map(Cell::getStringCellValue)
                    .forEach(prefectures::add);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prefectures;
    }

    private static List<Double> getPopulation() {
        List<Double> populations = new ArrayList<>();

        try (
                Workbook workbook = WorkbookFactory.create(new File("./contents/089/src/main/resources/n230200200.xlsx"))
        ) {
            Sheet sheet = workbook.getSheetAt(0);

            IntStream.rangeClosed(9, 55)
                    .mapToObj(sheet::getRow)
                    .map(row -> row.getCell(6))
                    .map(Cell::getNumericCellValue)
                    .forEach(populations::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return populations;
    }

    private static void createFile(List<String> prefectures, List<Double> populations) {
        try (
                FileOutputStream outputStream = new FileOutputStream("./contents/089/src/main/resources/myanswer01.xlsx");
                Workbook workbook = new XSSFWorkbook()
        ) {
            DataFormat format = workbook.createDataFormat();
            CellStyle style = workbook.createCellStyle();
            style.setDataFormat(format.getFormat("#,##0"));

            Sheet sheet = workbook.createSheet();
            for (int i = 0; i < 47; ++i) {
                Row row = sheet.createRow(i);
                Cell prefectureCell = row.createCell(0);
                Cell populationCell = row.createCell(1);
                populationCell.setCellStyle(style);
                prefectureCell.setCellValue(prefectures.get(i));
                populationCell.setCellValue(populations.get(i));
            }

            sheet.createRow(47).createCell(0).setCellValue("合計");
            sheet.createRow(47).createCell(1).setCellStyle(style);
            sheet.createRow(47).createCell(1).setCellFormula("SUM(B1:B47)");

            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
