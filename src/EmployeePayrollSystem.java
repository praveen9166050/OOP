import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    abstract public double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return this.monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return this.hourlyRate * this.hoursWorked;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(int id) {
        for (Employee employee : this.employees) {
            if (employee.getId() == id) {
                this.employees.remove(employee);
                break;
            }
        }
    }

    public void displayEmployees() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) throws Exception {
        PayrollSystem payrollSystem = new PayrollSystem();
        Employee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
        Employee emp2 = new PartTimeEmployee("Alexander", 2, 100, 40);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing an employee...");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();
    }
}