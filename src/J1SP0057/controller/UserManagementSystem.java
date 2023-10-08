package J1SP0057.controller;
import J1SP0057.model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class UserManagementSystem {
        private final String PATH = "\\src\\J1SP0057\\data\\user.dat";
        private final String BASE_PATH = new File("").getAbsolutePath();
        private List<Account> accounts;
        private File file;

        public UserManagementSystem() {
            accounts = new ArrayList<>();
            file = new File(BASE_PATH+PATH);
            loadAccounts();
        }

        public void displayMenu() {
            System.out.println("USER MANAGEMENT SYSTEM");
            System.out.println("1. Create a new account");
            System.out.println("2. Login System");
            System.out.println("3. Exit");
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createAccount(scanner);
                        break;
                    case 2:
                        login(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 3);
        }

        private void createAccount(Scanner scanner) {
            System.out.println("CREATE NEW ACCOUNT");
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            if (validateUsername(username) && validatePassword(password)) {
                Account newAccount = new Account(username, password);
                accounts.add(newAccount);
                saveAccounts();
                System.out.println("Account created successfully.");
            } else {
                System.out.println("Invalid username or password. Account creation failed.");
            }
        }

        private boolean validateUsername(String username) {
            if (username.length() >= 5 && !username.contains(" ")) {
                for (Account account : accounts) {
                    if (account.getUsername().equals(username)) {
                        return false; // Username already exists
                    }
                }
                return true;
            }
            return false;
        }

        private boolean validatePassword(String password) {
            return password.length() >= 6 && !password.contains(" ");
        }

        private void login(Scanner scanner) {
            System.out.println("LOGIN SYSTEM");
            System.out.print("Enter username: ");
            String username = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            boolean found = false;
            for (Account account : accounts) {
                if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid username or password. Login failed.");
            }
        }

        private void loadAccounts() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                accounts = (ArrayList<Account>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                // File does not exist or cannot be read, ignore and continue with an empty accounts list
            }
        }

        private void saveAccounts() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(accounts);
            } catch (IOException e) {
                System.out.println("Error saving accounts to file.");
            }
        }


    }
