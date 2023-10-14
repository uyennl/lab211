
package J1SP0059.common;

import java.util.Scanner;


public class Validate {

    private static final Scanner in = new Scanner(System.in);


    //check user input string
    public String checkInputPathFile() {
        System.out.print("Enter path file: ");
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input double
    public double checkInputMoney() {
        //loop until user input corect
        System.out.print("Enter money: ");
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }
}
