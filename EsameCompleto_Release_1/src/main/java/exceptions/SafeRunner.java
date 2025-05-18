package exceptions;

public class SafeRunner {
    public static void run(CheckedRunnable r) {
        try {
            r.run();
        } catch(Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
