package strategy;


// Concrete strategy: salario fisso
public class FixedSalaryStrategy implements SalaryStrategy {
    @Override
    public double calculate(double baseSalary) {
        return baseSalary + 500; // esempio: bonus fisso
    }
}

