package J1SP0064.checked_input;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.function.Predicate;

public class Input {
    public Input() {
    }

    ;
    Validator validator = new Validator();
    static Scanner sc = new Scanner(System.in);
    private static final String ERR_MESSAGE = "Wrong Input ! Please Re-enter ";
    private static final String REGEX_NOT_MATCH = "Input Not Valid ! Please Re-enter ";


    public String enterString(String mess, String regex) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.err.println(ERR_MESSAGE);
                continue;
            }

            boolean isTrue = validator.checkRegex(str, regex);
            if (isTrue) {
                return str;
            } else {
                System.err.println(REGEX_NOT_MATCH);
            }

        }
    }

    public String enterDate(String mess) {
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                String dateStr = sc.nextLine().trim();
                if (validator.isValidDate(dateStr)) {
                    return dateStr;
                }
                else{
                    System.err.println("ERR_MESSAGE");
                }
            } catch (NoSuchElementException e) {
                System.err.println(ERR_MESSAGE);
                continue;

            }
        }
    }



    public LocalDate enterDate(String mess, String pattern) {
        LocalDate result;
        while (true) {
            System.out.println("Enter " + mess + ":");
            try {
                String dateStr = sc.nextLine().trim();
                if (!validator.isValidDate(dateStr)) {
                    throw new ParseException("Invalid Date Format", 0);
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                formatter.withResolverStyle(ResolverStyle.STRICT);
                LocalDate date = LocalDate.parse(dateStr, formatter);
                result = date;
            } catch (ParseException e) {
                System.err.println(REGEX_NOT_MATCH);
                continue;
            } catch (NoSuchElementException e) {
                System.err.println(ERR_MESSAGE);
                continue;
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                continue;
            }
            return result;
        }
    }


}

