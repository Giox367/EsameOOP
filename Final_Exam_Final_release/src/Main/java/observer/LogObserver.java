package src.Main.java.observer;


import javax.swing.JTextArea;

// Observer concreto che aggiorna una JTextArea della GUI
public class LogObserver implements Observer {
    private JTextArea area;

    public LogObserver(JTextArea area) {
        this.area = area;
    }

    @Override
    public void update(String msg) {
        area.append(msg + "\n");
    }
}
