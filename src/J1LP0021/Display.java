package J1LP0021;

import javax.swing.*;
import java.util.ArrayList;

/**
 *@author UyenNguyễn
 *
 * */
public class Display {
void displayMenu(){
    System.out.println("WELCOME TO STUDENT MANAGEMENT");
    System.out.println("1. Create");
    System.out.println("2. Find and Sort");
    System.out.println("3. Update/Delete");
    System.out.println("4. Report");
    System.out.println("5. Exit");
}
void displayCouseMenu(){
    System.out.println("COURSE");
    System.out.println("1. Java");
    System.out.println("2. .Net");
    System.out.println("3. C/C++");
    }
    void displayList(ArrayList<Student> students, String displayType) {
        switch (displayType) {
            case "student_list":
                System.out.format("%5s%20s%10s%10s\n", "ID", "Name", "Semester", "Course");

                for (Student student : students) {
                    System.out.println(student);
                }
                break;
            case "update_or_delete_list":
                int rowNumber = 0;
                System.out.format("%10s%5s%20s%10s%10s\n", "Row Number", "ID",
                        "Name", "Semester", "Course");

                //Loop to get each student in student list
                for (Student student : students) {
                    System.out.format("%10s", ++rowNumber);
                    System.out.println(student);
                }

                break;
        }

    }

}
