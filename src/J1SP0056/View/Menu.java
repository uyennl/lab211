
package J1SP0056.View;

import J1SP0056.validate.Input;

import java.util.ArrayList;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mChon;
    Input input = new Input();

    public Menu() {
        mChon = new ArrayList<>();
    }

    public Menu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) {
            mChon.add((T) s);
        }
    }

    // -------------------------------------------
    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + "." + mChon.get(i));
        }
        System.out.println("--------------------------------");
    }
    // -------------------------------------------

    public int getSelected() {
        display();
        return input.enterInt("your choice", 1, mChon.size() + 1);
    }
    // -------------------------------------------

    public abstract void execute(int n);

    // public void run() {
    // do {
    // int n = getSelected();
    // execute(n);
    // } while (Algorithm.isContinue());
    // }
    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > mChon.size()) {
                break;
            }
        }
    }
}
