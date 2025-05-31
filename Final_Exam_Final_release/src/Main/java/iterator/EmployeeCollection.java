package iterator;

import factory.Employee;
import java.util.ArrayList;
import java.util.List;

// Collezione di Employee con iteratore
public class EmployeeCollection {
    private List<Employee> employees = new ArrayList<>();

    public void add(Employee e) {
        employees.add(e);
    }

    public EmployeeIterator iterator() {
        return new EmployeeIterator(employees);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }

}
