package utils;

import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    public static Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
        return logger;
    }
}
