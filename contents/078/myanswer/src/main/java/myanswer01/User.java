package myanswer01;

public record User(
        LoginName loginName,
        NickName nickName,
        Mail mail,
        Password password,
        BirthDay birthDay,
        Gender gender
) {
    public static User of(
            String loginNameString,
            String nickNameString,
            String mailString,
            String passwordString,
            String confirmationPassword,
            Integer year,
            Integer month,
            Integer day,
            String genderString
    ) {
        return new User(
                new LoginName(loginNameString),
                new NickName(nickNameString),
                new Mail(mailString),
                new Password(passwordString, confirmationPassword),
                new BirthDay(year, month, day),
                Gender.of(genderString)
        );
    }
}
