package iterator;

import factory.Employee;
import java.util.*;

public class EmployeeIterator {
    private List<Employee> list;
    private int index = 0;

    public EmployeeIterator(List<Employee> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public Employee next() {
        return list.get(index++);
    }
}
