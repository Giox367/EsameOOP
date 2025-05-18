package composite;

import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.List;

public class CompositeMenu implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public CompositeMenu(String name) {
        this.name = name;
    }

    public void add(Component component) {
        children.add(component);
    }

    public void displayTo(JTextArea area) {
        area.append(name + ":\n");
        for (Component child : children) {
            child.displayTo(area);
        }
    }
}

