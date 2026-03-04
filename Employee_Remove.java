import java.io.File;
import java.util.Scanner;

public class Employee_Remove {

    public Employee_Remove() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to Remove: ");
        String id = sc.nextLine();

        File file = new File("emp_" + id + ".txt");

        if (file.exists()) {
            file.delete();
            System.out.println("Employee Removed Successfully!");
        } else {
            System.out.println("Employee Not Found!");
        }
    }
}