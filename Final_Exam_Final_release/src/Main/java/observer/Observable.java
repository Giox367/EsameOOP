package observer;

import java.util.ArrayList;
import java.util.List;

// Classe Observable per gestire una lista di Observer
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
