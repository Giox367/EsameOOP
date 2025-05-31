package test;

import factory.Employee;
import iterator.EmployeeCollection;
import iterator.EmployeeIterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeIteratorTest {

    @Test
    public void testIteration() {
        EmployeeCollection collection = new EmployeeCollection();
        collection.add(new Employee("Luca", "HR"));
        collection.add(new Employee("Anna", "Marketing"));

        EmployeeIterator it = collection.iterator();
        assertTrue(it.hasNext());
        assertEquals("Luca", it.next().getName());
        assertEquals("Anna", it.next().getName());
        assertFalse(it.hasNext());
    }
}
