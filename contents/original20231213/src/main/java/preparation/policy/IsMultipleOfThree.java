package preparation.policy;

public class IsMultipleOfThree implements Rule {
    @Override
    public boolean ok(Integer num) {
        return num % 3 == 0;
    }
}
