package J1SP0050.validate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;
/**
 * Uyen Nguyễn
 * */
public class Validator {
    public Validator(){};

    public final String REGEX_NUMBER = "[0-9]+";
    public final String REGEX_YN = "^y|^n";
    public final String REGEX_Y = "[yY]";
    public  final String REGEX_UD = "^U|^D";
    public final String REGEX_NOR = ".+";
    public final String REGEX_NOSPECIAL= "^[a-zA-Z0-9 ]*$";
    public boolean checkRegex(String str, String regex) {
        return str.matches(regex);
    }

}
