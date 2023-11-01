package J1SP0078.validate;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.function.Predicate;
/**
 * Uyen Nguyễn
 * */
public class Input {
   public Input() {
    }

    ;
    static Scanner sc = new Scanner(System.in);
    private final String ERR_MESSAGE = "Wrong Input ! Please Re-enter ";
    private final String REGEX_NOT_MATCH = "Input Not Valid ! Please Re-enter ";
    Validator validator = new Validator();

    public String enterString(String mess) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            return str;

        }
    }

     public String enterString(String mess, String regex) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            boolean isTrue = validator.checkRegex(str, regex);
            if (isTrue) {
                return str;
            } else {
                System.out.println(REGEX_NOT_MATCH);
            }

        }
    }


    public String enterString(String mess, String regex, Predicate<String> duplicate) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            boolean isTrue = validator.checkRegex(str, regex);
            if (isTrue) {
                if (!duplicate.test(str)) {
                    return str;
                } else {
                    System.err.println(mess + " has exist");
                }
            } else {
                System.out.println(REGEX_NOT_MATCH);
            }

        }
    }



}

