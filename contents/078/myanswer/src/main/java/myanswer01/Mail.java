package myanswer01;

public record Mail(String name) {
    public Mail {
        if (name.isBlank()) throw new IllegalArgumentException("メールアドレスが入力されていません。");
        if (!name.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n")) throw new IllegalArgumentException("不正なメールアドレスです。");
    }
}
