package J1SP0054.Menu;

import java.util.Scanner;


public class Validation {

    private final static Scanner in = new Scanner(System.in);
    private static final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}" + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

    public String inputString(String msg) {
        String str;
        while (true) {
            System.out.println(msg);
            str = in.nextLine();
            if (str == null || str.length() == 0) {
                System.err.println("It can't empty, try again!!!");
                continue;
            }
            return str.trim();
        }
    }

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

    //check user input number limit
    public  int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.println("Enter again: ");
            }
        }
    }

    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input yes/ no
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }
    }

    //check input int
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Please input number");
                System.out.println("Enter again: ");
            }
        }
    }

    //check input phone
    public static String checkInputPhone() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }

            System.err.println("Please input Phone flow\n" + "• 1234567890\n" + "• 123-456-7890 \n" + "• 123-456-7890 x1234\n" + "• 123-456-7890 ext1234\n" + "• (123)-456-7890\n" + "• 123.456.7890\n" + "• 123 456 7890");
            System.out.println("Enter again: ");
        }
    }
}