package J1LP0021;

import J1LP0022.view.Menu;

import java.util.ArrayList;

/**
 * @author UyenNguyễn
 */
public class Main {

    public static void main(String[] args) throws Exception {
Manager ma = new Manager();

        Manager.students.add(new Student("1", "Uyen", "1", "Java"));
            Manager.students.add(new Student("2", "Ayen", "2", "Java"));
            Manager.students.add(new Student("2", "Hyen", "3", "Java"));
            Manager.students.add(new Student("4", "Nyen", "1", "Java"));
            Manager.students.add(new Student("5", "Gyen", "2", "Java"));
            Manager.students.add(new Student("6", "Byen", "4", "Java"));
            Manager.students.add(new Student("7", "Yyen", "2", "Java"));
            Manager.students.add(new Student("8", "Pyen", "3", "Java"));
            Manager.students.add(new Student("9", "Cyen", "4", "Java"));
            Manager.students.add(new Student("1", "Uyen", "2", "Java"));
ma.getMenu();

    }
}
