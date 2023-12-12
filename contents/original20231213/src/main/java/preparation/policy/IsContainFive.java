package preparation.policy;

public class IsContainFive implements Rule {
    @Override
    public boolean ok(Integer num) {
        return String.valueOf(num).contains("5");
    }
}
