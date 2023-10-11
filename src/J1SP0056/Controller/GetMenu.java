package J1SP0056.Controller;

import J1SP0056.Entity.History;
import J1SP0056.Entity.Worker;
import J1SP0056.View.Menu;

import java.util.ArrayList;

public class GetMenu extends Menu<String> {
  static  String[] options = { "Add Worker", "Up Salary", "Down Salary", "Display Information Salary" };
    ArrayList<Worker> lw = new ArrayList<>();
    ArrayList<History> lh = new ArrayList<>();
    Manager manager = new Manager();


    public GetMenu() {
        super("Worker Management", options);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                manager.addWorker(lw);
                break;
            case 2:
                manager.changeSalary(lw, lh, 1);
                break;
            case 3:
                manager.changeSalary(lw, lh, 2);
                break;
            case 4:
                manager.printListHistory(lh);
                break;
        }

    }

}
