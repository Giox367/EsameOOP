package observer;

import javax.swing.*;

public class LogObserver implements Observer {
    private JTextArea area;

    public LogObserver(JTextArea area) {
        this.area = area;
    }

    public void update(String msg) {
        area.append("🔔 " + msg + "\n");
    }
}
