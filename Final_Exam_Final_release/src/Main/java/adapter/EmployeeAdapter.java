package adapter;


import factory.Employee;

// Adapter per usare LegacyEmployee come Employee
public class EmployeeAdapter extends Employee {
    private LegacyEmployee legacyEmployee;

    public EmployeeAdapter(LegacyEmployee legacyEmployee) {
        super(legacyEmployee.getLegacyName(), legacyEmployee.getLegacyPosition());
        this.legacyEmployee = legacyEmployee;
    }

    @Override
    public String getName() {
        return legacyEmployee.getLegacyName();
    }

    @Override
    public String getRole() {
        return legacyEmployee.getLegacyPosition();
    }
}

