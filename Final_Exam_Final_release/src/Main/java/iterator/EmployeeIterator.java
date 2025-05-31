package src.Main.java.iterator;


import factory.Employee;
import java.util.Iterator;
import java.util.List;

// Iterator custom per la collezione Employee
public class EmployeeIterator implements Iterator<Employee> {
    private int index = 0;
    private List<Employee> list;

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
