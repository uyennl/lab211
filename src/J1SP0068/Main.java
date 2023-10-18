package J1SP0068;

import J1SP0068.Controller.StudentManager;
import J1SP0068.Model.Student;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        ArrayList<Student> lt = new ArrayList<>();
        studentManager.display(lt);
    }
}
