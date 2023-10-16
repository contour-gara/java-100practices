package myanswer01;

public record NickName(String name) {
    public NickName {
        if (name.isBlank()) throw new IllegalArgumentException("ニックネームが入力されていません。");
        if (!name.matches("^{1,15}$")) throw new IllegalArgumentException("ニックネームが15文字以内ではありません。");
    }
}
