package exceptions;

@FunctionalInterface
public interface CheckedRunnable {
    void run() throws Exception;
}
