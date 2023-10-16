package myanswer01;

public record Password(String password, String confirmationPassword) {
    public Password {
        if (password.isBlank()) throw new IllegalArgumentException("パスワードが入力されていません。");
        if (confirmationPassword.isBlank()) throw new IllegalArgumentException("確認用パスワードが入力されていません");
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) throw new IllegalArgumentException("不正なパスワードです。");
        if (password.equals(confirmationPassword)) throw new IllegalArgumentException("パスワードが一致しません。");
    }
}
