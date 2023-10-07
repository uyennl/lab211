package J1SP0055.control;

import J1SP0055.model.Doctor;
import J1SP0055.validate.Input;
import J1SP0055.validate.Validator;

import java.util.HashMap;

public class Manager {
    public Manager() {
    }

    //display menu
    Input input = new Input();
    Validator validator = new Validator();
    public HashMap<String, Doctor> doctorHash = new HashMap<>();

    public int menu() {

        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return input.enterInt("Your choice: ", 1, 6);
    }

    public Doctor addDoctor() {
        String name = input.enterString("Name ", validator.REGEX_FULL_NAME_VN);
        String specialization = input.enterString("Specialization", validator.REGEX_NOSPECIAL);
        int availability = input.enterInt("availability", 0, 100);
        Doctor doctor = new Doctor(name, specialization, availability);
        return doctor;
    }

    public void addHashDoctor(HashMap<String, Doctor> doctorHash, String code) {
        if (doctorHash.containsKey(code)) {
            System.out.println(code + "Đã tồn tại id");
        } else {
            doctorHash.put(code, addDoctor());
            System.out.println("Add success");
        }


    }

    public void updateHashDoctor(HashMap<String, Doctor> doctorHash, String code) {
        boolean flag = false;
        if (doctorHash.containsKey(code)) {
            doctorHash.put(code, addDoctor());
            System.err.println("Update success");
            flag = true;
        } else {
            System.err.println(code + "Code not found");
        }
    }


    public void deleteHashDoctor(HashMap<String, Doctor> doctorHash, String code) {
        if (doctorHash.containsKey(code)) {
            doctorHash.remove(code);
        } else {
            System.err.println("Code not found");
        }
    }

    public void searchHashDoctor(HashMap<String, Doctor> doctorHash, String code) {
        if (doctorHash.containsKey(code)) {
            System.out.println(code + ": " + doctorHash.get(code));
        } else {
            System.out.println("Code not found");
        }
    }

    public void getMenu() {
        while (true) {
            int choice = menu();
            String code;
            switch (choice) {
                case 1:
                    addHashDoctor(doctorHash, code = input.enterString("Code", validator.REGEX_DOCTOR));
                    break;
                case 2:
                    updateHashDoctor(doctorHash, code = input.enterString("Code", validator.REGEX_DOCTOR));
                    break;
                case 3:
                    deleteHashDoctor(doctorHash, code = input.enterString("Code", validator.REGEX_DOCTOR));
                    break;
                case 4:
                    searchHashDoctor(doctorHash, code = input.enterString("Code", validator.REGEX_DOCTOR));
                    break;
                case 5:
                    System.out.println(doctorHash);
                    break;
                case 6:
                    return;
            }

        }
    }
}
