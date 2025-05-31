package app;

// Import pattern e utilità
import factory.EmployeeFactory;
import factory.Employee;
import iterator.EmployeeCollection;
import iterator.EmployeeIterator;
import exceptions.SafeRunner;
import observer.Observable;
import observer.LogObserver;
import composite.CompositeMenu;
import composite.Leaf;
import utils.SingletonLogger;
import strategy.SalaryStrategy;
import strategy.FixedSalaryStrategy;
import strategy.HourlySalaryStrategy;
import adapter.EmployeeAdapter;
import adapter.LegacyEmployee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.logging.Logger;

public class Main {
    public static boolean isInputValid(String nome) {
        if (nome == null) return false;
        nome = nome.trim();
        if (nome.isEmpty()) return false;
        if (nome.length() < 2) return false;
        if (!nome.matches("[A-Za-zÀ-ÿ '\\-]+")) return false; // solo lettere, spazi, trattini e apostrofi
        return true;
    }

    public static void main(String[] args) {
        Logger logger = SingletonLogger.getInstance().getLogger();
        logger.info("Applicazione avviata");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestione Dipendenti");
            frame.setSize(800, 400);
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
            CompositeMenu dev = new CompositeMenu("Sviluppo");
            dev.add(new Leaf("Backend"));
            dev.add(new Leaf("Frontend"));
            root.add(dev);
            root.add(new Leaf("Risorse Umane"));
            root.add(new Leaf("Marketing"));
            root.add(new Leaf("Contabilità"));

            area.append("Struttura dei Dipartimenti Aziendali:\n");
            root.displayTo(area);

            // Strategy pattern: scegli strategia salario in base al reparto
            SalaryStrategy fixedStrategy = new FixedSalaryStrategy();
            SalaryStrategy hourlyStrategy = new HourlySalaryStrategy();

            addButton.addActionListener(e -> SafeRunner.run(() -> {
                String nome = nomeField.getText().trim();
                String reparto = (String) repartoBox.getSelectedItem();
                String ruolo = reparto;

                if ("Sviluppo".equals(reparto)) {
                    ruolo = (String) subRepartoBox.getSelectedItem();
                }

                // Sanificazione input
                if (!isInputValid(nome)) {
                    JOptionPane.showMessageDialog(frame, "Nome non valido. Inserisci solo lettere, almeno 2 caratteri.");
                    return;
                }
                if (ruolo == null || ruolo.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Scegli un reparto valido!");
                    return;
                }

                SalaryStrategy strategy = ruolo.equals("Backend") ? fixedStrategy : hourlyStrategy;
                Employee emp = factory.createEmployee(nome, ruolo);
                emp.setSalaryStrategy(strategy);
                collection.add(emp);
                observable.notifyAll("Aggiunto: " + emp + " - Salario: " + emp.calculateSalary(2000));
                logger.info("Aggiunto dipendente: " + emp.getName() + " - " + emp.getRole());
                nomeField.setText("");
                repartoBox.setSelectedIndex(0);
            }));

            showButton.addActionListener(e -> SafeRunner.run(() -> {
                area.append("\nElenco Dipendenti:\n");
                EmployeeIterator it = collection.iterator();
                while (it.hasNext()) {
                    Employee emp = it.next();
                    area.append(emp.toString() + " (Salario: " + emp.calculateSalary(2000) + ")\n");
                }
                // Adapter example
                LegacyEmployee legacyEmp = new LegacyEmployee("Mario Vecchio", "Manager");
                EmployeeAdapter adapter = new EmployeeAdapter(legacyEmp);
                area.append("Dipendente Legacy adattato: " + adapter.getName() + " - " + adapter.getRole() + "\n");
            }));

            frame.setVisible(true);
        });
    }
}
