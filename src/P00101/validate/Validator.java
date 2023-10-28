package P00101.validate;
import java.util.Scanner;

/**
 *
 * Uyên Nguyễn
 */
public class Validator {

    public String inputString(String title) {
        String s = "";
        while ( s.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.println(title + ": ");
            s = sc.nextLine();
        }
        return s;
    }
}