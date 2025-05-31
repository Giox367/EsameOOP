package test;

import strategy.FixedSalaryStrategy;
import strategy.HourlySalaryStrategy;
import strategy.SalaryStrategy;
import factory.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    @Test
    public void testFixedSalaryStrategy() {
        SalaryStrategy strategy = new FixedSalaryStrategy();
        assertEquals(2500.0, strategy.calculate(2000.0));
    }

    @Test
    public void testHourlySalaryStrategy() {
        SalaryStrategy strategy = new HourlySalaryStrategy();
        assertEquals(2400.0, strategy.calculate(2000.0));
    }
}
