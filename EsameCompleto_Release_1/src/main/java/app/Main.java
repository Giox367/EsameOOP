package app;

import factory.EmployeeFactory;
import factory.Employee;
import iterator.EmployeeCollection;
import iterator.EmployeeIterator;
import exceptions.SafeRunner;
import observer.Observable;
import observer.LogObserver;
import composite.CompositeMenu;
import composite.Leaf;
import java.util.logging.Logger;
import utils.LoggerUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestione Dipendenti");
            frame.setSize(700, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JTextArea area = new JTextArea();
            area.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(area);
            frame.add(scrollPane, BorderLayout.CENTER);

            JTextField nomeField = new JTextField(10);
            String[] reparti = {"Sviluppo", "Risorse Umane", "Marketing", "Contabilità"};
            JComboBox<String> repartoBox = new JComboBox<>(reparti);

            String[] subRepartiSviluppo = {"Backend", "Frontend"};
            JComboBox<String> subRepartoBox = new JComboBox<>(subRepartiSviluppo);
            subRepartoBox.setVisible(false);

            JButton addButton = new JButton("Aggiungi");
            JButton showButton = new JButton("Mostra");

            JPanel inputPanel = new JPanel();
            inputPanel.add(new JLabel("Nome:"));
            inputPanel.add(nomeField);

            inputPanel.add(new JLabel("Reparto:"));
            inputPanel.add(repartoBox);

            inputPanel.add(new JLabel("Sotto-Reparto:"));
            inputPanel.add(subRepartoBox);

            inputPanel.add(addButton);
            inputPanel.add(showButton);
            frame.add(inputPanel, BorderLayout.NORTH);

            repartoBox.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) repartoBox.getSelectedItem();
                    subRepartoBox.setVisible("Sviluppo".equals(selected));
                    inputPanel.revalidate();
                    inputPanel.repaint();
                }
            });

            EmployeeFactory factory = new EmployeeFactory();
            EmployeeCollection collection = new EmployeeCollection();

            Observable observable = new Observable();
            observable.subscribe(new LogObserver(area));

            CompositeMenu root = new CompositeMenu("Dipartimenti");
            root.add(new Leaf("Risorse Umane"));
            root.add(new Leaf("Marketing"));
            root.add(new Leaf("Contabilità"));

            CompositeMenu dev = new CompositeMenu("Sviluppo");
            dev.add(new Leaf("Backend"));
            dev.add(new Leaf("Frontend"));
            root.add(dev);



            area.append("Struttura dei Dipartimenti Aziendali:\n");
            root.displayTo(area);

            addButton.addActionListener(e -> SafeRunner.run(() -> {
                String nome = nomeField.getText().trim();
                String reparto = (String) repartoBox.getSelectedItem();
                String ruolo = reparto;

                if ("Sviluppo".equals(reparto)) {
                    ruolo = (String) subRepartoBox.getSelectedItem();
                }

                if (!nome.isEmpty() && ruolo != null) {
                    Employee emp = factory.createEmployee(nome, ruolo);
                    collection.add(emp);
                    observable.notifyAll("Aggiunto: " + emp);
                    nomeField.setText("");
                    repartoBox.setSelectedIndex(0);
                }
            }));

            showButton.addActionListener(e -> SafeRunner.run(() -> {
                area.append("\nElenco Dipendenti:\n");
                EmployeeIterator it = collection.iterator();
                while (it.hasNext()) {
                    area.append(it.next().toString() + "\n");
                }
            }));

            frame.setVisible(true);
        });
    }
}
