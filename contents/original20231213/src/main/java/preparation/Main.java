package preparation;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        FizzBuzzUseCase fizzBuzzUseCase = new FizzBuzzUseCase();

        IntStream.rangeClosed(1, 100)
                .mapToObj(fizzBuzzUseCase::execute)
                .forEach(System.out::println);
    }
}
