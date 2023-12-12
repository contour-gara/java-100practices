package preparation.policy;

public class IsMultipleOfFive implements Rule {
    @Override
    public boolean ok(Integer num) {
        return num % 5 == 0;
    }
}
