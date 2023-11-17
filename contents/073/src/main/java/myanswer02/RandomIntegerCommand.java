package myanswer02;

import java.util.Random;

public class RandomIntegerCommand extends AbstractCommand<Integer> {
    private final Random random = new Random();

    @Override
    protected Integer executeInner() {
        return random.nextInt();
    }
}
