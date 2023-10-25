package J1SP0070;

import J1SP0070.TPBank.TPBank;

public class Main {
    public static void main(String[] args) {
        TPBank tpBank = new TPBank("Login Program\n--------------------", new String[]{"Vietnamese", "English", "Exit"});
        tpBank.run();
    }
}
