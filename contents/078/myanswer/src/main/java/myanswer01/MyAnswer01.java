package myanswer01;

public class MyAnswer01 {
    public static void main(String[] args) {
        User user = User.of(
                "gara",
                "garaa",
                "gara@334.co.jp",
                "gara",
                "gara",
                1990,
                1,
                1,
                "女性"
        );

        System.out.println(user);
    }
}
