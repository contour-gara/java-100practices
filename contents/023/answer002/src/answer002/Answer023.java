package answer002;

/**
 * 023の解答です.
 *
 * @author jsfkdt
 */
public class Answer023 {
    /**
     * 023の解答です.
     * int型やfloat型を引数に持つ同名のメソッドを使用し、
     * String型の結果を取得する.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        System.out.println(convertToString(100));
        System.out.println(convertToString(100f));

    }

    /**
     * int型で渡された引数をString型に変換し返却する.
     *
     * @param word int型の引数
     * @return int型からString型へ変換した結果.
     */
    private static String convertToString(final int word) {
        return String.valueOf("int型からString型へ変換した結果：" + word);
    }

    /**
     * float型で渡された引数をString型に変換し返却する.
     *
     * @param word float型の引数
     * @return float型からString型へ変換した結果.
     */
    private static String convertToString(final float word) {
        return String.valueOf("float型からString型へ変換した結果：" + word);
    }
}
