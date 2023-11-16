package myanswer01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class AbstractCommandTest {
    AbstractCommand abstractCommand;

    @BeforeEach
    void setUp() {
        abstractCommand = spy(AbstractCommand.class);
    }

    @Test
    void コマンド実行前() {
        // assert
        Status actual = abstractCommand.getStatus();
        Status expected = Status.NONE;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void コマンド終了後() {
        // setup
        when(abstractCommand.executeInner())
                .thenReturn(1);

        // execute
        abstractCommand.execute();

        // assert
        Status actualStatus = abstractCommand.getStatus();
        Status expectedStatus = Status.SUCCESS;
        assertThat(actualStatus).isEqualTo(expectedStatus);

        Object actualResult = abstractCommand.getResult();
        assertThat(actualResult).isEqualTo(1);
    }

    @Test
    void 例外発生時() {
        // setup
        doThrow(new RuntimeException()).when(abstractCommand).executeInner();

        // execute
        abstractCommand.execute();

        // assert
        Status actualStatus = abstractCommand.getStatus();
        Status expectedStatus = Status.ERROR;
        assertThat(actualStatus).isEqualTo(expectedStatus);

        Exception actualException = abstractCommand.getException();
        assertThat(actualException).isInstanceOf(RuntimeException.class);
    }
}
