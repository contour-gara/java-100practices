package myanswer01;

public class User {
    private final LoginName loginName;
    private final NickName nickName;
    private final Mail mail;
    private final Password password;
    private final BirthDay birthDay;
    private final Gender gender;

    public User(
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
        this.loginName = new LoginName(loginNameString);
        this.nickName = new NickName(nickNameString);
        this.mail = new Mail(mailString);
        this.password = new Password(passwordString, confirmationPassword);
        this.birthDay = new BirthDay(year, month, day);
        this.gender = Gender.of(genderString);
    }

    public LoginName getLoginName() {
        return loginName;
    }

    public NickName getNickName() {
        return nickName;
    }

    public Mail getMail() {
        return mail;
    }

    public Password getPassword() {
        return password;
    }

    public BirthDay getBirthDay() {
        return birthDay;
    }

    public Gender getGender() {
        return gender;
    }
}
