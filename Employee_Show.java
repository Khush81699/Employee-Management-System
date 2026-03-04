import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee_Show {

    public Employee_Show() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to View: ");
        String id = sc.nextLine();

        try {
            File file = new File("emp_" + id + ".txt");

            if (!file.exists()) {
                System.out.println("Employee Not Found!");
                return;
            }

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error Reading File!");
        }
    }
}