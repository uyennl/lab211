package J1LP0022.control;

import J1LP0022.view.Menu;

/**
 * Uyen Nguyễn
 * */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("CANDIDATE MANAGERMANT SYSTEM", new String[] {"Experience","Fresher","Internship","Searching","Exit"});
        menu.run();

    }
}
