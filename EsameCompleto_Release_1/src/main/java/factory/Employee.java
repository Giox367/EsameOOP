package factory;

public class Employee {
    private String name, department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name + " (" + department + ")";
    }

    public String toCSV() {
        return name + "," + department;
    }
}
