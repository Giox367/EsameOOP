package iterator;

import factory.Employee;
import java.util.*;

public class EmployeeCollection {
    private List<Employee> list = new ArrayList<>();

    public void add(Employee e) {
        list.add(e);
    }

    public EmployeeIterator iterator() {
        return new EmployeeIterator(list);
    }
}
