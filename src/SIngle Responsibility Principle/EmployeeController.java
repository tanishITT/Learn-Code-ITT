public class EmployeeController {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 5000.0, "Software Engineer");

        SalaryCalculator calculator = new SalaryCalculator();
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeReportGenerator reportGenerator = new EmployeeReportGenerator();

        repository.save(employee);

        String report = reportGenerator.generateReport(employee, calculator);
        System.out.println(report);
    }
}
