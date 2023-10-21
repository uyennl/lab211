package J1SP0067;

import J1SP0067.Controller.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        System.out.println("===== Analysis String program ====");
        System.out.println("Input String");
        String input = sc.nextLine();
        manager.display(input);
    }
}
