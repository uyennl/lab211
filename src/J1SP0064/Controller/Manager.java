package J1SP0064.Controller;

import J1SP0064.Model.Data;
import J1SP0064.checked_input.Input;
import J1SP0064.checked_input.Validator;

import java.util.ArrayList;

public class Manager {
    public Manager(){};
    Input input = new Input();
    Validator validator = new Validator();
    public void addData(ArrayList<Data> datas){
String phoneNumber = input.enterString("Phone Number", validator.REGEX_PHONE_NUMBER);
String email = input.enterString("Email",validator.REGEX_EMAIL);
String date  = input.enterDate("Date");
    }

}
