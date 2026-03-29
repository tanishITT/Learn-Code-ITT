class EmployeeRepository {
    private List<Employee> database = new ArrayList<>();

    public void save(Employee employee) {
        database.add(employee);
        System.out.println("Employee saved: " + employee.getName());
    }

    public Employee findByName(String name) {
        return database.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}