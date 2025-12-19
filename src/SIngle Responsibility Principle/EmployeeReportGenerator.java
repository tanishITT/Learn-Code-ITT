
class EmployeeReportGenerator {
    public String generateReport(Employee employee, SalaryCalculator calculator) {
        StringBuilder report = new StringBuilder();
        report.append("Employee Report\n");
        report.append("===============\n");
        report.append("Name: ").append(employee.getName()).append("\n");
        report.append("Position: ").append(employee.getPosition()).append("\n");
        report.append("Monthly Salary: $").append(employee.getSalary()).append("\n");
        report.append("Annual Salary: $").append(calculator.calculateAnnualSalary(employee)).append("\n");
        report.append("Bonus: $").append(calculator.calculateBonus(employee)).append("\n");
        return report.toString();
    }
}