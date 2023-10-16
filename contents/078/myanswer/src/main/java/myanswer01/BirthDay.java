package myanswer01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.util.Objects.isNull;

public record BirthDay(Integer year, Integer month, Integer day) {
    public BirthDay {
        if (isNull(year)) throw new IllegalArgumentException("年が入力されていません。");
        if (isNull(month)) throw new IllegalArgumentException("月が入力されていません。");
        if (isNull(day)) throw new IllegalArgumentException("日が入力されていません。");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate date = LocalDate.parse(String.format("%d-%02d-%02d", year, month, day), formatter);

            if (date.isAfter(LocalDate.now())) throw new IllegalArgumentException("未来の日付が入力されています。");
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("生年月日が不正です。");
        }
    }
}
