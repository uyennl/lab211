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
//date dùng date
//-----------------------------------------------------------
//                     VALID DATE
//-----------------------------------------------------------
public Date getDate() throws ParseException {
    String input;
    while (true) {
        System.out.println("Enter Date");
        input = sc.nextLine();
        if (validDate(input)) {
            break;
        } else {
            System.out.println("Invalid Date input");
        }
    }
    return parseDate(input);
}
//-----------------------------------------------------------

    public Date parseDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.parse(date);
    }
//-----------------------------------------------------------

    public boolean validDate(String dob) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            Date dateFormat = df.parse(dob);
            Calendar calendar = Calendar.getInstance();
            calendar.setLenient(false);
            calendar.setTime(dateFormat);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            if (year > 2023) {
                return false;
            }
            if (month == 2) {
                return validFebrary(day, year);
            } else {
                return validMonth(day, month);
            }
        } catch (ParseException e) {
            return false;
        }
    }
//-----------------------------------------------------------

    public boolean validMonth(int day, int month) {
         switch (month) {
             case 1:
             case 3:
             case 5:
             case 7:
             case 8:
             case 10:
             case 12:
                    if(day >= 1 && day <= 31){
                        return true;
                    }
                    break;
             case 4:
             case 6:
             case 9:
             case 11:
                    if(day >= 1 && day <= 30){
                        return true;
                    }
                    break;
             default:
                    break;
        };
         return true;
    }
    //Enhanced 'switch' blocks are not supported at language level '8
//-----------------------------------------------------------

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 == 0) || (year % 400 == 0);
    }
//-----------------------------------------------------------

    public boolean validFebrary(int day, int year) {
        if (isLeapYear(year)) {
            return day >= 1 && day <= 29;
        } else {
            return day >= 1 && day <= 28;
        }
    }

//-----------------------------------------------------------
//                     END
//-----------------------------------------------------------

}

