package observer;

import java.util.*;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void notifyAll(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}
