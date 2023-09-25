package J1LP0023.control;

import J1LP0023.model.Fruit;
import J1LP0023.validate.Input;
import J1LP0023.validate.Validator;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class Manager {
    ArrayList<Fruit> fruits = new ArrayList<>();
    HashMap<String, List<Fruit>> hashTable = new HashMap<>();
    Input input = new Input();
    Validator validator = new Validator();
    void getMenu() {
        int choice;
        do {
            displayMenu();
            choice = J1LP0021.Input.enterInt("", 1, 4);
            switch (choice) {
                case 1:
                    createFruit();
                    break;
                case 2:
                   viewOrders();
                    break;
                case 3:
                    shopping();
                    break;
            }

        }
        while (choice < 4);
    }
    void createFruit() {
        while (true) {
            String id = input.enterString("Id", validator.REGEX_ID, (i) -> {
                for (Fruit f : fruits) {
                    if (f.getId().equals(i)) {
                        return true;
                    }
                }
                return false;
            });
            String name = input.enterString("Fruit name", validator.REGEX_NOSPECIAL);
            int price = input.enterInt("Price", 0, 1000000);
            int quantyti = input.enterInt("Quantity", 0, 100);
            String origin = input.enterString("Origin");
            fruits.add(new Fruit(id, name, price, origin, quantyti));
            System.out.println("Enter y/y to continue, n/N to back to screen");
       if(input.checkInputYN()){
           continue;
       }
       else break;
        }
    }
    void displayListFruit(){
        System.out.println("List of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (Fruit f : fruits) {
            System.out.printf("       %-13s%-18s%-15s%-10s \n", f.getId(), f.getName(), f.getOrigin(), f.getPrice());
        }
        if (fruits.size() == 0) {
            System.err.println("You must create at least one Fruit");
        }
    }
    void shopping(){
        List<Fruit> listBuy = new ArrayList<>();
        displayListFruit();
        String nameCustomer = input.enterString("Name Customer", validator.REGEX_NOSPECIAL);

        while(true){
            int select = input.enterInt("item you want order",1,fruits.size());
            Fruit fruitNum = fruits.get(select-1);
            System.out.println("You selected: "+ fruitNum.getName());
            int quantity = input.enterInt("Quantyti",0,100);
            fruitNum.setQuantity(quantity);
            listBuy.add(fruitNum);
            System.out.println("Do you want to order now (Y|N)");
            if(!input.checkInputYN()){
                continue;
            }
            else{
                System.out.println("Product | Quantity | Price | Amount ");
                double total = 0;
                for (Fruit f : listBuy) {
                    System.out.println(f.getName() + "  " + quantity + "    " + f.getPrice() + "     " + (quantity * f.getPrice()));
                    total += quantity * f.getPrice();
                }
                System.out.println("Total: " + total);
                hashTable.put(nameCustomer, listBuy);
                break;
            }
        }
    }
    public void viewOrders() {
        for (String nameCustomer : hashTable.keySet()) {
            System.out.println("Customer: " + nameCustomer);
            System.out.println("Product | Quantity | Price | Amount ");
            double total = 0;
            for (Fruit f : hashTable.get(nameCustomer)) {
                System.out.println(f.getName() + "  " + f.getQuantity() + "    " + f.getPrice() + "     " + (f.getQuantity() * f.getPrice()));
                total += f.getQuantity() * f.getPrice();
            }
            System.out.println("Total: " + total);
        }
    }
    void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create fruit");
        System.out.println("2. View order");
        System.out.println("3. Shopping(for buyer)");
        System.out.println("4. Exit");
    }
}
