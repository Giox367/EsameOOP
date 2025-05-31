package src.Main.java.service;

import src.Main.java.factory.Employee;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Esempio multithreading: salva la lista dei dipendenti in modo asincrono
public class AsyncSaveService extends Thread {
    private List<Employee> employees;

    public AsyncSaveService(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void run() {
        try (FileWriter fw = new FileWriter("dipendenti_async.txt", false)) {
            for (Employee e : employees) {
                fw.write(e.toString() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Errore nel salvataggio async: " + ex.getMessage());
        }
    }
}
