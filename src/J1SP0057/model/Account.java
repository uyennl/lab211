package J1SP0057.model;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
///**
// * Uyen Nguyễn
// * */
//public class Manager {
//    private final String PATH = "\\src\\J1LP0025\\data\\user.dat";
//    private final String BASE_PATH = new File("").getAbsolutePath();
//       Validate  validate = new Validate();
//
//    //display menu
//    public int menu() {
//        System.out.println("1. Create a new account.");
//        System.out.println("2. Login system.");
//        System.out.println("3. Exit.");
//        System.out.print("Enter your choice: ");
//        int choice = validate.checkInputIntLimit(1, 3);
//        return choice;
//    }
//    public void getMenu(){
//        while (true) {
//            int choice = menu();
//            switch (choice) {
//                case 1:
//                    createNewAccount();
//                    break;
//                case 2:
//                    loginSystem();
//                    break;
//                case 3:
//                    return;
//            }
//        }
//    }
//
//    //create a new account
//    public void createNewAccount() {
//        //check file data exist or not
//        if (!validate.checkFileExist()) {
//            return;
//        }
//        String username = validate.checkInputUsername();
//        String password = validate.checkInputPassword();
//        //check username exist or not
//        if (!validate.checkUsernameExist(username)) {
//            System.err.println("Username exist.");
//            return;
//        }
//        addAccountData(username, password);
//    }
//
//    //login system
//    public void loginSystem() {
//        //check file data exist or not
//        if (!validate.checkFileExist()) {
//            return;
//        }
//        String username = validate.checkInputUsername();
//        String password = validate.checkInputPassword();
//        //check username exist or not
//        if (!validate.checkUsernameExist(username)) {
//            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
//                System.err.println("Password incorrect.");
//            }
//            System.err.println("Login success.");
//        }
//    }
//
//    //write new account to data
//    public void addAccountData(String username, String password) {
//        File file = new File(BASE_PATH+PATH);
//        try {
//            FileWriter fileWriter = new FileWriter(file, true);
//            fileWriter.write(username + ";" + password + "\n");
//            fileWriter.close();
//            System.err.println("Create successly.");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    //get password by username
//    public String passwordByUsername(String username) {
//        File file = new File("");
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] account = line.split(";");
//                if (username.equalsIgnoreCase(account[0])) {
//                    return account[1];
//                }
//            }
//            bufferedReader.close();
//            fileReader.close();
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

   public class Account {
        private String username;
        private String password;

        public Account(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }


//}
