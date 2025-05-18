package test;

import factory.EmployeeFactory;
import factory.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFactoryTest {

    @Test
    public void testCreateEmployee() {
        EmployeeFactory factory = new EmployeeFactory();
        Employee emp = factory.createEmployee("Mario", "Backend");
        assertEquals("Mario", emp.getName());
        assertEquals("Backend", emp.getRole());
    }
}
