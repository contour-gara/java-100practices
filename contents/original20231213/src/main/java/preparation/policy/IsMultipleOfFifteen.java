package preparation.policy;

public class IsMultipleOfFifteen implements Rule {
    @Override
    public boolean ok(Integer num) {
        return num % 15 == 0;
    }
}
