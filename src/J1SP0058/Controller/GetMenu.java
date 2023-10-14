package J1SP0058.Controller;


import J1SP0058.RWFlie.ReadWriteFile;
import J1SP0058.View.Menu;

import java.util.HashMap;

public class GetMenu extends Menu {
    Manager manager = new Manager();
    public HashMap<String, String> hm = new HashMap<>();

    public GetMenu(String title, String[] s) {

        super(title, s);
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                manager.addNewWord(hm);
                break;
            case 2:
                 manager.deleteWord(hm);
                break;
            case 3:
                manager.translate(hm);
                break;
            case 4:
                return true;

            default:
                break;
        }
        return false;
    }

}


