package live;

public class IsContainsFive implements Rule {
    @Override
    public Boolean ok(Integer num) {
        return String.valueOf(num).contains("5");
    }
}
