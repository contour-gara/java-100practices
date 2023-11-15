package myanswer02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    @Test
    void ログイン名にnullは許容されない() {
        // assert
        assertThatThrownBy(() -> new User(null, "gara@co.jp", "12345678aA", "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ログイン名は0文字以上で、空文字のみは許容されません。");
    }

    @Test
    void ログイン名にスペースのみは許容されない() {
        // assert
        assertThatThrownBy(() -> new User(" ", "gara@co.jp", "12345678aA", "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ログイン名は0文字以上で、空文字のみは許容されません。");
    }

    @Test
    void ログイン名は0文字以上である() {
        // assert
        assertThatThrownBy(() -> new User("", "gara@co.jp", "12345678aA", "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ログイン名は0文字以上で、空文字のみは許容されません。");
    }

    @Test
    void ログイン名は半角英数のみである() {
        // assert
        assertThatThrownBy(() -> new User("全角", "gara@co.jp", "12345678aA", "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("ログイン名は半角英数のみです。");
    }

    @Test
    void メールアドレス形式以外は許容されない() {
        // assert
        assertThatThrownBy(() -> new User("gara", "garaco.jp", "12345678aA", "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("メールアドレスはメールアドレス形式のみです。");
    }

    @Test
    void メールアドレスにnullは許容されない() {
        // assert
        assertThatThrownBy(() -> new User("gara", null, "12345678aA", "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("メールアドレスはメールアドレス形式のみです。");
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            1234567
            12345678
            abcdefgh
            ABCDEFGH
            1234567a
            1234567A
            abcdefgH
            12345aAあ
            """)
    void パスワードは大文字と小文字と数字が混在する(String password) {
        // assert
        assertThatThrownBy(() -> new User("gara", "gara@co.jp", password, "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("パスワードは8文字以上の半角英数字で、大文字と小文字と数字を全て使ってください。");
    }

    @Test
    void パスワードはnullを許容しない() {
        // assert
        assertThatThrownBy(() -> new User("gara", "gara@co.jp", null, "12345678aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("パスワードはnullを許容しない。");
    }

    @Test
    void 確認用パスワードはパスワードと一致しなければならない() {
        // assert
        assertThatThrownBy(() -> new User("gara", "gara@co.jp", "12345678aA", "1234567aA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("パスワードが一致しません。");
    }
}
