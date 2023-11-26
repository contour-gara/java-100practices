package preparation;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    public List<Integer> execute(Integer number) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= number; ++i) {
            BinaryNumber binaryNumber = new BinaryNumber(i);
            result.add(binaryNumber.countNumberOfOneInBinary());
        }
        return result;
    }
}
