package J1SP0058.Controller;

import J1SP0058.RWFlie.ReadWriteFile;
import J1SP0058.validate.Input;
import J1SP0058.validate.Validator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Manager {
    Input input = new Input();
    Validator validator = new Validator();
    ReadWriteFile readWriteFile = new ReadWriteFile();



    public void addNewWord(HashMap<String, String> hm) {
        String english = input.enterString("Enlish",validator.REGEX_NOSPECIAL);
        if (!checkKeywordExist(hm, english)) {
            if (!input.checkInputYN()) {
                return;
            }
        }
        String vietnam = input.enterString("Vietnamese",validator.REGEX_VN);
        //check key word english exist or not
        hm.put(english, vietnam);
        readWriteFile.saveWordsToFile(hm);
        System.err.println("Add successful.");
    }

    //delete word
    public  void deleteWord(HashMap<String, String> hm) {
        String english = input.enterString("Enlish",validator.REGEX_NOSPECIAL);
        hm.remove(english);
        System.err.println("Delete successful.");
    }

    //translate
//    public void translate(HashMap<String, String> hm) {
//        String english = input.enterString("Enlish",validator.REGEX_NOSPECIAL);
//        Set<Map.Entry<String, String>> entries = hm.entrySet();
//        for (Map.Entry entry : entries) {
//            if (entry.getKey().equalsIgnoreCase(english)) {
//                System.out.println("Vietnamese: " + entry.getValue());
//                return;
//            }
//        }
//        System.err.println("Not found in data");
//    }
    public void translate(HashMap<String, String> hm) {
        String english = input.enterString("English", validator.REGEX_NOSPECIAL);
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().equalsIgnoreCase(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

    //check key englist exist
    public  boolean checkKeywordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
