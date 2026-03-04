import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Employee_Update {

    public Employee_Update() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to Update: ");
        String id = sc.nextLine();

        File file = new File("emp_" + id + ".txt");

        if (!file.exists()) {
            System.out.println("Employee Not Found!");
            return;
        }

        try {
            FileWriter fw = new FileWriter(file);

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter New Salary: ");
            String salary = sc.nextLine();

            fw.write("Employee ID: " + id + "\n");
            fw.write("Name: " + name + "\n");
            fw.write("Department: " + dept + "\n");
            fw.write("Salary: " + salary + "\n");

            fw.close();

            System.out.println("Employee Updated Successfully!");

        } catch (IOException e) {
            System.out.println("Error Updating File!");
        }
    }
}