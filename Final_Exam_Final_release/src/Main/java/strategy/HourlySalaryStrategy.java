package strategy;


// Concrete strategy: salario orario con maggiorazione
public class HourlySalaryStrategy implements SalaryStrategy {
    @Override
    public double calculate(double baseSalary) {
        return baseSalary * 1.2; // esempio: +20%
    }
}
