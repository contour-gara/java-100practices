package myanswer02;

import org.apache.commons.validator.routines.EmailValidator;

import static org.apache.commons.lang3.StringUtils.isAsciiPrintable;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static java.util.Objects.isNull;

public record User(
        String loginName,
        String mailAdress,
        String password,
        String confirmPassword
) {
    public User {
        if (isBlank(loginName)) throw new IllegalArgumentException("ログイン名は0文字以上で、空文字のみは許容されません。");
        if (!isAsciiPrintable(loginName)) throw new IllegalArgumentException("ログイン名は半角英数のみです。");
        if (!EmailValidator.getInstance().isValid(mailAdress))
            throw new IllegalArgumentException("メールアドレスはメールアドレス形式のみです。");
        if (isNull(password)) throw new IllegalArgumentException("パスワードはnullを許容しない。");
        if (!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d.?/-]{8,}$")))
            throw new IllegalArgumentException("パスワードは8文字以上の半角英数字で、大文字と小文字と数字を全て使ってください。");
        if (!password.equals(confirmPassword)) throw new IllegalArgumentException("パスワードが一致しません。");
    }
}
