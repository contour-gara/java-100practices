package myanswer01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

class AbstractCommandTest {
    @Spy
    AbstractCommand abstractCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void コマンド実行前() {
        // assert
        assertThat(abstractCommand.getStatus()).isEqualTo(Status.NONE);
        assertThat(abstractCommand.getResult()).isNull();
        assertThat(abstractCommand.getException()).isNull();
    }

    @Test
    void コマンド終了後() {
        // setup
        doReturn(1).when(abstractCommand).executeInner();

        // execute
        abstractCommand.execute();

        // assert
        assertThat(abstractCommand.getStatus()).isEqualTo(Status.SUCCESS);
        assertThat(abstractCommand.getResult()).isEqualTo(1);
        assertThat(abstractCommand.getException()).isNull();
    }

    @Test
    void 例外発生時() {
        // setup
        doThrow(new RuntimeException()).when(abstractCommand).executeInner();

        // execute
        abstractCommand.execute();

        // assert
        assertThat(abstractCommand.getStatus()).isEqualTo(Status.ERROR);
        assertThat(abstractCommand.getResult()).isNull();
        assertThat(abstractCommand.getException()).isInstanceOf(RuntimeException.class);
    }
}
