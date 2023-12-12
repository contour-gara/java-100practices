package preparation.policy;

import preparation.FizzBuzzType;

public class FizzBuzzPolicy {
    private static final IsMultipleOfFifteen IS_MULTIPLE_OF_FIFTEEN = new IsMultipleOfFifteen();
    private static final IsContainFive IS_CONTAIN_FIVE = new IsContainFive();
    private static final IsMultipleOfFive IS_MULTIPLE_OF_FIVE = new IsMultipleOfFive();
    private static final IsContainsThree IS_CONTAINS_THREE = new IsContainsThree();
    private static final IsMultipleOfThree IS_MULTIPLE_OF_THREE = new IsMultipleOfThree();

    public FizzBuzzType apply(Integer num) {
        if (IS_MULTIPLE_OF_FIFTEEN.ok(num)) return FizzBuzzType.FIZZ_BUZZ;
        if (IS_CONTAIN_FIVE.ok(num) || IS_MULTIPLE_OF_FIVE.ok(num)) return FizzBuzzType.BUZZ;
        if (IS_CONTAINS_THREE.ok(num) || IS_MULTIPLE_OF_THREE.ok(num)) return FizzBuzzType.FIZZ;
        return FizzBuzzType.NUMBER;
    }
}
