package J1SP0058;

import J1SP0058.Controller.GetMenu;
import J1SP0058.RWFlie.ReadWriteFile;

public class Main {
    public static void main(String[] args) {
        GetMenu getMenu = new GetMenu("Dictionary program--------------------", new String[]{"Add word", "Delete word", "Translate word", "Exit"});
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.loadWordsFromFile(getMenu.hm);
        getMenu.run();
    }
}
