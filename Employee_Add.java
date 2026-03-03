import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Employee_Add {

    public Employee_Add() {

        EmployDetail emp = new EmployDetail();
        emp.getDetails();

        try {
            File file = new File("emp_" + emp.id + ".txt");

            if (file.exists()) {
                System.out.println("Employee already exists!");
                return;
            }

            FileWriter fw = new FileWriter(file);

            fw.write("Employee ID: " + emp.id + "\n");
            fw.write("Name: " + emp.name + "\n");
            fw.write("Department: " + emp.department + "\n");
            fw.write("Salary: " + emp.salary + "\n");

            fw.close();

            System.out.println("Employee Added Successfully!");

        } catch (IOException e) {
            System.out.println("Error Creating File!");
        }
    }
}