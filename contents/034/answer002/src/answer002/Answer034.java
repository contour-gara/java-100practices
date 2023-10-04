package answer002;

/**
 * 034の解答です.
 *
 * @author jsfkdt
 */
public class Answer034 {
    /**
     * 034の解答です.
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        final java.util.List<String> medals = new java.util.ArrayList<>();
        medals.add("gold");
        medals.add("silver");
        medals.add("bronze");
        medals.forEach(System.out::println);
    }
}
