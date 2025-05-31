package src.Main.java.exceptions;


import utils.SingletonLogger;

// Utility per esecuzione sicura di codice Runnable (Exception Shielding)
public class SafeRunner {
    public static void run(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            SingletonLogger.getInstance().getLogger().severe("Errore gestito: " + e.getMessage());
            System.out.println("Errore gestito in sicurezza.");
        }
    }
}
