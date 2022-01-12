package myapp.services;

public interface ILogger {
    default void log(String message) {}
}
