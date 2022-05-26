package carsharing.cli;

public interface Action<T> {
    T execute();
}
