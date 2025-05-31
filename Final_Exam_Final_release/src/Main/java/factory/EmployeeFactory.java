package src.Main.java.factory;



import utils.SingletonLogger;

public class EmployeeFactory {
    public Employee createEmployee(String name, String role) {
        SingletonLogger.getInstance().getLogger().info("Creating employee: " + name + " - " + role);
        return new Employee(name, role);
    }
}
