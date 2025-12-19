class SalaryCalculator {
    public double calculateAnnualSalary(Employee employee) {
        return employee.getSalary() * 12;
    }

    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.1;
    }
}