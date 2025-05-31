package test;

import adapter.EmployeeAdapter;
import adapter.LegacyEmployee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {

    @Test
    public void testEmployeeAdapter() {
        LegacyEmployee legacy = new LegacyEmployee("Vecchio Mario", "SuperManager");
        EmployeeAdapter adapter = new EmployeeAdapter(legacy);
        assertEquals("Signor Mario", adapter.getName());
        assertEquals("SuperManager", adapter.getRole());
    }
}
