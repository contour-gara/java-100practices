package live;

public class IsMultipleOfThree implements Rule {
    @Override
    public Boolean ok(Integer num) {
        return num % 3 == 0;
    }
}
