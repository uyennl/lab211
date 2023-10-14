
package J1SP0058.View;


import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {


    protected String title;
    protected ArrayList<String> list = new ArrayList();

    public Menu() {
    }

    public Menu(String title, String[] s) {
        this.title = title;
        for (String item : s) {
            list.add(item);
        }
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter selection: ");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public void run() {
        while (true) {
            display();
            int choice = 0;
            try {
                choice = getChoice();

            } catch (NumberFormatException e) {
                System.out.println("Wrong, try to enter 1 to " + list.size());
                continue;//
            }
            if (choice <= 0 || choice > list.size()) {
                System.out.println("You must choice from 1 to " + list.size());
                continue;
            }
            boolean isExit = execute(choice);
            if (isExit) {
                break;
            }
        }
    }

    public abstract boolean execute(int choice);

}