package myanswer01;

public interface Command<T> {
    void execute();

    Status getStatus();

    T getResult();

    Exception getException();
}
