package live;

public class IsContainsThree implements Rule {
    @Override
    public Boolean ok(Integer num) {
        return String.valueOf(num).contains("3");
    }
}
