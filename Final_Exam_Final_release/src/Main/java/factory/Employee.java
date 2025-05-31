package src.Main.java.factory;


import strategy.SalaryStrategy;

public class Employee {
    private String name;
    private String role;
    private SalaryStrategy salaryStrategy;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() { return name; }
    public String getRole() { return role; }

    public void setSalaryStrategy(SalaryStrategy strategy) {
        this.salaryStrategy = strategy;
    }

    public double calculateSalary(double base) {
        if (salaryStrategy == null) return base;
        return salaryStrategy.calculate(base);
    }

    public String toString() {
        return name + " - " + role;
    }
}
