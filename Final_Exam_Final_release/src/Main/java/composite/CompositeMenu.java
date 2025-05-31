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

    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void displayTo(JTextArea area) {
        area.append(name + ":\n");
        for (Component c : children) {
            c.displayTo(area);
        }
    }
}
