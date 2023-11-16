public interface Command<T> {
    void execute();

    Status getStatus();

    T getResult();

    Exception getException();
}
