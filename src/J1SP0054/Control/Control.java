package J1SP0054.Control;

import J1SP0054.Data.Contact;

import J1SP0054.Data.Method;
import J1SP0052.view.Menu;

import java.util.ArrayList;

public class Control extends Menu<String> {
    static String[] menu = {"Add a contact", "Display all contact", "Delete a contact", "Exit"};
    protected Method mt = new Method();
    ArrayList<Contact> lc = new ArrayList<>();
    private Menu.Validation check = new Menu.Validation();
//------------------------------------------------------------------------------------------------------------------

    public Control() {
        super("Contact Manager SYS!!!", menu);
        lc.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        lc.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        lc.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
    }

    @Override
    public void execute(int n) {

        switch (n) {
            case 1:
                mt.createContact(lc);
                break;

            case 2:
                mt.printAllContact(lc);
                break;

            case 3:
                mt.deleteContactd(lc);
                break;

        }
    }

}
