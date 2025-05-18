package factory;

public class EmployeeFactory {
    public Employee createEmployee(String name, String department) {
        return new Employee(name, department);
    }
}
