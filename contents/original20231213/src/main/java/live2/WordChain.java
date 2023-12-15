package live2;

import java.util.ArrayList;
import java.util.List;

public class WordChain {
    private final List<String> alreadyUsed = new ArrayList<>();

    public void add(String addWord) {
        alreadyUsed.add(addWord);
    }

    public Boolean hiraganaCheck(String addWord) {
        return addWord.matches("^[\\u3040-\\u309F]+$");
    }

    public Boolean endCheck(String addWord) {
        return addWord.charAt(addWord.length() - 1) != 'ん';
    }

    public Boolean duplicationCheck(String addWord) {
        return !alreadyUsed.contains(addWord);
    }

    public Boolean frontCheck(String addWord) {
        String lastWord = alreadyUsed.get(alreadyUsed.size() - 1);
        return lastWord.charAt(lastWord.length() - 1) !=  addWord.charAt(0);
    }

    public List<String> getAlreadyUsed() {
        return alreadyUsed;
    }
}
