package factory;



import utils.SingletonLogger;

// Classe factory per creare Employee

public class EmployeeFactory {
    public Employee createEmployee(String name, String role) {
        SingletonLogger.getInstance().getLogger().info("Creating employee: " + name + " - " + role);
        return new Employee(name, role);
    }
}
