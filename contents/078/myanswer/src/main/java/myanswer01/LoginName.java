package myanswer01;

public record LoginName(String name) {
    public LoginName {
        if (name.isBlank()) throw new IllegalArgumentException("ログイン名が入力されていません。");
        if (!name.matches("^[a-zA-Z0-9]{1,15}$")) throw new IllegalArgumentException("ログイン名が16文字以内の半角英数字ではありません。");
    }
}
