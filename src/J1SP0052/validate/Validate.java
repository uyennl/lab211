package J1SP0052.validate;

import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);
    private final static Scanner in = new Scanner(System.in);
    //------------------------------------------------------------------------------------------------------------------
    //check user input double limit
    public double checkInputFloat() {
        //loop until user input correct
        while (true) {
            try {
                float result = Float.parseFloat(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public String inputString(String msg) {
        String str;
        while (true) {
            System.out.println(msg);

            str = sc.nextLine();
            if (str == null || str.length() == 0) {
                System.err.println("It can't empty, try again!!!");
                continue;
            }
            return str.trim();
        }
    }

    public String checkInputString() {
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
    //------------------------------------------------------------------------------------------------------------------
    public int checkNum(String msg) {
        String regex = "^[0-9]";
        int number = 0;
        while (true) {
            String num = inputString(msg);
            if (num.matches(regex)) {
                number = Integer.parseInt(num);
                return number;
            } else {
                System.err.println("It must be a number");
            }
        }

    }
    //------------------------------------------------------------------------------------------------------------------
}
