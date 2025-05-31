package composite;

import javax.swing.JTextArea;

// Elemento del Composite pattern
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void displayTo(JTextArea area) {
        area.append(" - " + name + "\n");
    }
}
