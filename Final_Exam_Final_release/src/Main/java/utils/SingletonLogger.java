package src.Main.java.utils;


import java.util.logging.Logger;

// Singleton pattern per Logger condiviso
public class SingletonLogger {
    private static SingletonLogger instance;
    private Logger logger;

    private SingletonLogger() {
        logger = Logger.getLogger("AziendaManager");
    }

    public static SingletonLogger getInstance() {
        if (instance == null) {
            instance = new SingletonLogger();
        }
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }
}
