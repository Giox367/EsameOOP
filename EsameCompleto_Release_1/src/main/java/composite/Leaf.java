package composite;

import javax.swing.JTextArea;

public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void displayTo(JTextArea area) {
        area.append(" - " + name + "\n");
    }
}
