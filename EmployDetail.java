import java.util.Scanner;

public class EmployDetail {

    String id;
    String name;
    String department;
    String salary;

    Scanner sc = new Scanner(System.in);

    public void getDetails() {

        System.out.print("Enter Employee ID: ");
        id = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Department: ");
        department = sc.nextLine();

        System.out.print("Enter Salary: ");
        salary = sc.nextLine();
    }
}