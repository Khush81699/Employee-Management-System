import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}

public class EmployeeManagementSystem {

    static final String FILE_NAME = "employees.dat";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Enter number only.");
                continue;
            }

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add Employee
    static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine());

            ArrayList<Employee> list = loadEmployees();
            list.add(new Employee(id, name, dept, salary));
            saveEmployees(list);

            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {
            System.out.println("Invalid Input! Try again.");
        }
    }

    // View Employees
    static void viewEmployees() {
        ArrayList<Employee> list = loadEmployees();

        if (list.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        for (Employee e : list) {
            e.display();
        }
    }

    // Update Employee
    static void updateEmployee() {
        try {
            System.out.print("Enter Employee ID to Update: ");
            int id = Integer.parseInt(sc.nextLine());

            ArrayList<Employee> list = loadEmployees();
            boolean found = false;

            for (Employee e : list) {
                if (e.getId() == id) {
                    System.out.print("Enter New Name: ");
                    e.setName(sc.nextLine());

                    System.out.print("Enter New Department: ");
                    e.setDepartment(sc.nextLine());

                    System.out.print("Enter New Salary: ");
                    e.setSalary(Double.parseDouble(sc.nextLine()));

                    found = true;
                    break;
                }
            }

            if (found) {
                saveEmployees(list);
                System.out.println("Employee Updated Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    // Delete Employee
    static void deleteEmployee() {
        try {
            System.out.print("Enter Employee ID to Delete: ");
            int id = Integer.parseInt(sc.nextLine());

            ArrayList<Employee> list = loadEmployees();
            boolean removed = list.removeIf(e -> e.getId() == id);

            if (removed) {
                saveEmployees(list);
                System.out.println("Employee Deleted Successfully!");
            } else {
                System.out.println("Employee Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    // Save to File
    static void saveEmployees(ArrayList<Employee> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error Saving Data!");
        }
    }

    // Load from File
    static ArrayList<Employee> loadEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Employee>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
