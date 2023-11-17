package myanswer02;

import lombok.Getter;

@Getter
public abstract class AbstractCommand<T> implements Command<T> {
    private Status status = Status.NONE;
    private T result = null;
    private Exception exception = null;

    protected abstract T executeInner();

    @Override
    public void execute() {
        try {
            status = Status.EXECUTING;
            result = executeInner();
            status = Status.SUCCESS;
        } catch (Exception e) {
            status = Status.ERROR;
            result = null;
            exception = e;
        }
    }
}
