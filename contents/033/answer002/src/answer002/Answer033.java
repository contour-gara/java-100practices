package answer002;

import java.util.List;
import java.util.Arrays;
/**
 * 033の解答です.
 *
 * @author jsfkdt
 */
public class Answer033 {
    /**
     * 033の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream().filter(x->x % 2 == 1).forEach(System.out::println);
    }

}
