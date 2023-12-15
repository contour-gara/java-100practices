package live2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordChainTest {
    @Test
    void 配列に文字列を追加できる() {
        // setup
        WordChain sut = new WordChain();

        // execute
        sut.add("文字列");
        List<String> actual = sut.getAlreadyUsed();

        //assert
        List<String> expected = List.of("文字列");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void ひらがな以外の場合() {
        // setup
        WordChain sut = new WordChain();

        // execute
        Boolean actual = sut.hiraganaCheck("漢字");

        // assert
        assertThat(actual).isFalse();
    }

    @Test
    void ひらがなの場合() {
        // setup
        WordChain sut = new WordChain();

        // execute
        Boolean actual = sut.hiraganaCheck("ひらがな");

        // assert
        assertThat(actual).isTrue();
    }

    @Test
    void んで終わらない場合() {
        // setup
        WordChain sut = new WordChain();

        // execute
        Boolean actual = sut.endCheck("ひらがな");

        // assert
        assertThat(actual).isTrue();
    }

    @Test
    void んで終わる場合() {
        // setup
        WordChain sut = new WordChain();

        // execute
        Boolean actual = sut.endCheck("ひらがなん");

        // assert
        assertThat(actual).isFalse();
    }

    @Test
    void 一度使用したものを使用した場合() {
        // setup
        WordChain sut = new WordChain();
        sut.add("あ");

        // execute
        Boolean actual = sut.duplicationCheck("あ");

        // assert
        assertThat(actual).isFalse();
    }

    @Test
    void 一度使用していないものを使用した場合() {
        // setup
        WordChain sut = new WordChain();
        sut.add("あ");

        // execute
        Boolean actual = sut.duplicationCheck("い");

        // assert
        assertThat(actual).isTrue();
    }

    @Test
    void 前の単語の末尾から始まらない場合() {
        // setup
        WordChain sut = new WordChain();
        sut.add("あいう");

        // execute
        Boolean actual = sut.frontCheck("い");

        // assert
        assertThat(actual).isTrue();
    }

    @Test
    void 前の単語の末尾から始まる場合() {
        // setup
        WordChain sut = new WordChain();
        sut.add("あいう");

        // execute
        Boolean actual = sut.frontCheck("う");

        // assert
        assertThat(actual).isFalse();
    }
}
