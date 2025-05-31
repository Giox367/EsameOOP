package test;

import org.junit.jupiter.api.Test;
import utils.SingletonLogger;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonLoggerTest {

    @Test
    public void testSingletonInstance() {
        SingletonLogger instance1 = SingletonLogger.getInstance();
        SingletonLogger instance2 = SingletonLogger.getInstance();
        assertSame(instance1, instance2);
        Logger logger = instance1.getLogger();
        assertNotNull(logger);
    }
}
