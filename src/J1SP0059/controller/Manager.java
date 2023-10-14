
package J1SP0059.controller;

import J1SP0059.common.Library;
import J1SP0059.view.Menu;


public class Manager extends Menu<String> {

    private Library library;

    public Manager() {
        super("Main Menu", new String[]{"Find person info", "Copy text to new file", "Exit"});
        library = new Library();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                library.findPersonInfo();
                break;
            case 2:
                library.coppyNewFile();
                break;
            case 3:
                System.out.println("Exiting the program.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }

    }
}
