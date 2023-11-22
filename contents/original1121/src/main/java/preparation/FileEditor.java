package preparation;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileEditor {
    public List<String> reverseAndRemoveKanji(List<String> inputs) {
        List<String> result = new ArrayList<>();

        for (int i = inputs.size() - 1; i >= 0; --i) {
            if (notContainKanji(inputs.get(i))) result.add(inputs.get(i));
        }
        return result;
    }

    private boolean containKanji(String input) {
        return input.matches(".*[一-龯].*");
    }

    private boolean notContainKanji(String input) {
        return !containKanji(input);
    }
}
