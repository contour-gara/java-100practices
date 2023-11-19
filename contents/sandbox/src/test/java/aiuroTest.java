import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class aiuroTest {
    @BeforeEach
    void setUp() {
        System.out.println("前準備");
    }

    @AfterEach
    void tearUp() {
        System.out.println("後片付け");
    }

    @Test
    void 例外発生() {
        throw new RuntimeException();
    }
}
