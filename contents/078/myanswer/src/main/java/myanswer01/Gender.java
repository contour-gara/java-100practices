package myanswer01;

import static java.util.Objects.isNull;

public enum Gender {
    MALE("男性"),
    FEMALE("女性"),
    OTHER("その他");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender of(String genderString) {
        if (isNull(genderString)) throw new IllegalArgumentException("性別を入力してください。");
        if (genderString.equals("男性")) return Gender.MALE;
        if (genderString.equals("女性")) return Gender.FEMALE;
        if (genderString.equals("その他")) return Gender.OTHER;
        throw new IllegalArgumentException("男性、女性、その他から選び入力してください。");
    }
}
