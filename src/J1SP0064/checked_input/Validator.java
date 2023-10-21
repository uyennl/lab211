package J1SP0064.checked_input;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;
public class Validator {
    public Validator(){};

    public  final String REGEX_PHONE_NUMBER = "09[0-9]{8}";
    public final String REGEX_FULL_NAME_VN = "[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+((\\s[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+)+)?";
//    public final String REGEX_EMAIL = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";

    public final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public boolean checkRegex(String str, String regex) {
        return str.matches(regex);
    }

    public boolean isValidDate(String date) {
//        dd/MM/yyyy
        String[] dateStr = date.split("/");
        int[] intArr = new int[3];
        for(int i =0 ;i<3;i++){
            intArr[i] = Integer.parseInt(dateStr[i]);
        }
        if (intArr[0] > 31 || intArr[0] < 0 || intArr[1] > 12 || intArr[1] < 0 || intArr[2] < 0) {
            return false;
        }else if(intArr[1] == 4 || intArr[1] == 6 || intArr[1] == 9 || intArr[1] == 11){
            if(intArr[0] == 31){
                return false;
            }
        }else if(intArr[1]==2){
            if(intArr[0]== 29 && (intArr[2] % 400  !=0 || (intArr[2] %100 ==0 && intArr[2] % 4 != 0))){
                return false;
            }
        }
        return true;
    }
}
