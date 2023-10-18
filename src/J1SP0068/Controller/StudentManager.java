package J1SP0068.Controller;

import J1SP0068.Model.Student;
import J1SP0068.validate.Input;
import J1SP0068.validate.Validator;

import java.util.ArrayList;
import java.util.Collections;

public class StudentManager {
    Input input = new Input();
    Validator validator = new Validator();

    public void addStudent(ArrayList<Student> lt) {
        System.out.println("Please input student information ");
        String name = input.enterString("Student name: ", validator.REGEX_FULL_NAME_VN);
        String classes = input.enterString("Class", validator.REGEX_NOR);
        float mark = input.enterFloat("Mark");
        lt.add(new Student(name, mark, classes));
    }

    public void checkEmpty(ArrayList<Student> lt) {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
    }

    public void sortStudentByName(ArrayList<Student> lt) {
        Collections.sort(lt, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        lt.forEach(e ->
        {
            System.out.println("--------Student " + (lt.indexOf(e) + 1) + "--------");
            System.out.println(e);
        });
    }

    public void display(ArrayList<Student> lt) {
        addStudent(lt);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (input.checkInputYN()) {
                addStudent(lt);
            } else {
                break;
            }
        }
        checkEmpty(lt);
        sortStudentByName(lt);
    }

}
