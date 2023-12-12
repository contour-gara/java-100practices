package preparation;

import preparation.policy.FizzBuzzPolicy;

public class FizzBuzzUseCase {
    public String execute(Integer num) {
        FizzBuzzPolicy policy = new FizzBuzzPolicy();
        return String.format("%d: %s", num, policy.apply(num).execute());
    }
}
