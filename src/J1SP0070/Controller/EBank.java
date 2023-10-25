package J1SP0070.Controller;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EBank {
    public final String MATKHAU = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
    public final String TAIKHOAN = "^[0-9]{10}$";
    public Scanner sc = new Scanner(System.in);
    public ResourceBundle bundle;
    //chon ngon ngu

    public void setLocate(Locale locate) {
        Locale.setDefault(locate);
        bundle = ResourceBundle.getBundle("J1SP0070.Language.language");
    }

    //tra ngon ngu sang interface
    public ResourceBundle getBundle() {
        return bundle;
    }

    public boolean checkCorrect(String input, String regex, String err) {
        if (!input.matches(regex)) {
            return false;
        }
        return true;
    }
//    public static void main(String[] args) {
//        Locale.setDefault(new Locale("vn", "VN"));
//
//
//        System.out.println(rs.getString("password"));
//    }

    public String generateCaptcha() {
        char[] charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        Random rd = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 1; i <= 6; i++) {
            int randomIndexCharSet = rd.nextInt(charSet.length);
            captcha.append(charSet[randomIndexCharSet]);
        }
        return captcha.toString();
    }

    public boolean checkCaptcha(String captchaGenerate, String captchaInput) {
        if (!captchaGenerate.contains(captchaInput) || captchaInput.length() == 0) {
            return false;
        }
        return true;
    }

    public String getString(String note, String regex, String err) {
        Scanner sc = new Scanner(System.in);
        String input;

        do {
            System.out.println(bundle.getString(note));
            input = sc.nextLine();

            // check input for validity
            checkCorrect(input, regex, err);

            if (checkCorrect(input, regex, err)) {
                return input;
            }
            System.out.println(err);
        } while (true);
    }

    public void login() {

        String acountNumber = getString("account", TAIKHOAN, "account.error");
        String passWord = getString("password", MATKHAU, "password.error");
        String captcha = generateCaptcha();
        System.out.println(bundle.getString("captcha"));
        System.out.println(captcha);
        while (true) {
            String captchaUser = sc.nextLine();
            if (checkCaptcha(captcha, captchaUser)) {

                System.out.println(bundle.getString("login.success"));
                return;
            } else {

                System.out.println(bundle.getString("captcha.incorrect"));
                System.out.println(bundle.getString("captcha.user"));
            }
        }
    }
}
