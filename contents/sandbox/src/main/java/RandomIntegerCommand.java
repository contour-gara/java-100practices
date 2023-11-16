import java.util.Random;

public class RandomIntegerCommand extends AbstractCommand<Integer> {
    private final Random random;

    public RandomIntegerCommand() {
        random = new Random();
    }

    public RandomIntegerCommand(long seed) {
        random = new Random(seed);
    }

    @Override
    protected Integer executeInner() {
        return random.nextInt();
    }
}
