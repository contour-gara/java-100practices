package myanswer01;

import java.util.Map;

import static myanswer01.ReadExcel.readExcel;
import static myanswer01.WriteCsv.writeCsv;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> map = readExcel("./contents/090/src/main/resources/n230200200.xlsx");
        writeCsv("./contents/090/src/main/resources/population.csv", map);
    }
}
