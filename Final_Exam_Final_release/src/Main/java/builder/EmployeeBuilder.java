package src.Main.java.builder;
import src.Main.java.factory.Employee;
import src.Main.java.strategy.SalaryStrategy;

// Esempio di pattern Builder opzionale
public class EmployeeBuilder {
    private String name;
    private String role;
    private SalaryStrategy salaryStrategy;

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder setRole(String role) {
        this.role = role;
        return this;
    }

    public EmployeeBuilder setSalaryStrategy(SalaryStrategy strategy) {
        this.salaryStrategy = strategy;
        return this;
    }

    public Employee build() {
        Employee emp = new Employee(name, role);
        emp.setSalaryStrategy(salaryStrategy);
        return emp;
    }
}
