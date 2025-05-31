package src.Main.java.utils;



import src.Main.java.composite.CompositeMenu;
import src.Main.java.composite.Component;
import src.Main.java.composite.Leaf;
import java.lang.reflect.Constructor;
import java.util.List;

// Reflection per creare dinamicamente menu dei dipartimenti
public class DepartmentLoader {
    public static CompositeMenu loadDepartments(List<String> departments, List<String> subDevs) {
        CompositeMenu root = null;
        try {
            Class<?> compositeClass = Class.forName("composite.CompositeMenu");
            Constructor<?> compositeCons = compositeClass.getConstructor(String.class);
            root = (CompositeMenu) compositeCons.newInstance("Dipartimenti");

            for (String dept : departments) {
                if (dept.equals("Sviluppo") && subDevs != null && !subDevs.isEmpty()) {
                    CompositeMenu dev = (CompositeMenu) compositeCons.newInstance("Sviluppo");
                    for (String sub : subDevs) {
                        dev.add(new Leaf(sub));
                    }
                    root.add(dev);
                } else {
                    root.add(new Leaf(dept));
                }
            }
        } catch (Exception e) {
            System.out.println("Errore reflection: " + e.getMessage());
        }
        return root;
    }
}
