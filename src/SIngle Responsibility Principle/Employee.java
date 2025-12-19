
class Employee {
    private String name;
    private double salary;
    private String position;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getPosition() { return position; }

    public void setSalary(double salary) { this.salary = salary; }
}