package preparation.policy;

public class IsContainsThree implements Rule {
    @Override
    public boolean ok(Integer num) {
        return String.valueOf(num).contains("3");
    }
}
