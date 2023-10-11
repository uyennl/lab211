package J1SP0056.Controller;

import J1SP0056.Entity.History;
import J1SP0056.Entity.Worker;
import J1SP0056.validate.Input;
import J1SP0056.validate.Validator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Manager {
    Input input = new Input();
    Validator validator = new Validator();

    public void addWorker(ArrayList<Worker> lw) {
        String id = input.enterString("ID", validator.REGEX_NOSPECIAL, (i) ->
        {
            for (Worker w : lw) {
                if (w.getId().equals(i)) {
                    return true;
                }

            }
            return false;
        });
        String name = input.enterString("Name", validator.REGEX_FULL_NAME_VN);
        int age = input.enterInt("Age", 18, 50);
        int salary = input.enterInt("Salary", 0, Integer.MAX_VALUE);
        String workLocation = input.enterString("Work Location", validator.REGEX_NOSPECIAL);
        lw.add(new Worker(id, name, age, salary, workLocation));
    }

    public void changeSalary(ArrayList<Worker> lw, ArrayList<History> lh, int status) {
        checkEmpty(lh);
        System.out.print("Enter code: ");
        String id = input.enterString("Code", validator.REGEX_NOSPECIAL);
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            if (status == 1) {
                while (true) {
                    salaryUpdate = input.enterInt("Salary Update", 0, Integer.MAX_VALUE);
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            } else {
                while (true) {
                    salaryUpdate = input.enterInt("Salary Update", 0, Integer.MAX_VALUE);
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("DOWN", getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }

    public void printListHistory(ArrayList<History> lh) {
       checkEmpty(lh);
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        for (History history : lh) {
            printHistory(history);
        }
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
    public static Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }
    public void checkEmpty(ArrayList<History> lh){
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
    }
    public void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
