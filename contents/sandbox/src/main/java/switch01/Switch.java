package switch01;

public class Switch {
    public static void main(String[] args) {
        int i = 3;
        switch (i) {
            case 0:
                System.out.println(0);
            case 2:
                System.out.println(2);
            case(3):
                System.out.println(3);
            case(4):
                System.out.println(4);
            default:
                System.out.println("default");
        }
    }
}
