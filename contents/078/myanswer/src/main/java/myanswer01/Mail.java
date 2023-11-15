package myanswer01;

import org.apache.commons.validator.routines.EmailValidator;

public record Mail(String email) {
    public Mail {
        if (email.isBlank()) throw new IllegalArgumentException("メールアドレスが入力されていません。");
        if (notCorrectEmail(email)) throw new IllegalArgumentException("不正なメールアドレスです。");
    }

    private boolean correctEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    private boolean notCorrectEmail(String email) {
        return !correctEmail(email);
    }
}
