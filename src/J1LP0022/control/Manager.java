package J1LP0022.control;

import J1LP0022.model.Candidate;
import J1LP0022.model.Experience;
import J1LP0022.model.Fresher;
import J1LP0022.model.Internship;
import J1LP0022.validate.Input;
import J1LP0022.validate.Validator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Predicate;

/**
 * Uyen Nguyễn
 */
public class Manager {
    ArrayList<Candidate> candidates = new ArrayList<>();

    public void addCandidate(int type) {
        boolean continueAdding = true;
        while (continueAdding) {
            String id = Input.enterString("Id", Validator.REGEX_ID, (i) -> {
                for (Candidate c : candidates) {
                    if (c.getId().equals(i)) {
                        return true;
                    }
                }
                return false;
            });
            String fistName = Input.enterString("Fist Name ", Validator.REGEX_FULL_NAME_VN);
            String lastName = Input.enterString("Last Name", Validator.REGEX_FULL_NAME_VN);
            int birthDate = Input.enterInt("Birthdate ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            String address = Input.enterString("Address", Validator.REGEX_NOR);
            String phone = Input.enterString("Phone Number ", Validator.REGEX_PHONE_NUMBER);
            String email = Input.enterString("Email ", Validator.REGEX_EMAIL);
            switch (type) {
                case 0:
                    int yearExperience = Input.enterInt("Year Experience ", 0, 100);
                    String professionalSkill = Input.enterString("Professional Skill ", Validator.REGEX_NOR);
                    candidates.add(new Experience(id, fistName, lastName, birthDate, address, phone, email, type, yearExperience, professionalSkill));
                    break;
                case 1:
                    String graduationDate = Input.enterString("GraduationDate");
                    String graduationRank = Input.enterRank("Graduation", Validator.REGEX_RANK);
                    candidates.add(new Fresher(id, fistName, lastName, birthDate, address, phone, email, type, graduationDate, graduationRank));
                    break;
                case 2:
                    String major = Input.enterString("Major ", Validator.REGEX_NOR);
                    String semester = Input.enterString("Semester", Validator.REGEX_NOR);
                    String university = Input.enterString("University", Validator.REGEX_NOR);
                    candidates.add(new Internship(id, fistName, lastName, birthDate, address, phone, email, type, major, semester, university));
                    break;
            }
            System.out.print("Do you want to continue (Y/N): ");
            continueAdding = Input.checkInputYN();
            if (continueAdding && type != 0) {
                break;
            }
        }
    }


    public ArrayList<Candidate> search(Predicate<Candidate> p) {
        ArrayList<Candidate> rs = new ArrayList<>();
        for (Candidate s : candidates) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;

    }
    public void searchCandidate(){
        String name = Input.enterString("Name",Validator.REGEX_FULL_NAME);
        int typeCandidate = Input.enterInt("Type Candidate",0,2);
        int count = 0;
        ArrayList<Candidate> search = search(i->i.getLFName().contains(name));
        if(search.isEmpty()){
            System.out.println("Empty");
        }
        else{
            for (Candidate candidate : candidates){
                if(candidate.getTypeCadidate() == typeCandidate){
                    System.out.println(search.toString());
                    count++;
                }
            }
        }
        if(count==0){
            System.out.println("Empty");
        }
    }

//    public void searchCandidate() {
//        printListNameCandidate();
//        String nameSearch = Input.enterString("Name",Validator.REGEX_FULL_NAME);
//        int typeCandidate = Input.enterInt("Type Candidate",0,2);
//        int count = 0;
//        for (Candidate candidate : candidates) {
//            if (candidate.getTypeCadidate() == typeCandidate){
//                  if(candidate.getFname().contains(nameSearch)
//                        || candidate.getLname().contains(nameSearch)) {
//                    System.out.println(candidate.toString());
//                    count++;
//                }
//            }
//
//        }
//        if (count == 0) {
//            System.out.println("not found");
//        }
//    }

    public void printListNameCandidate() {
        int countExperience = 0;
        int countFresher = 0;
        int countIntern = 0;
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                countExperience++;
                if (countExperience == 1) {
                    System.out.println("========Experience Candidate========");
                }
                System.out.println(candidate.getFname()+" "+candidate.getLname());
            }
            if (candidate instanceof Fresher) {
                countFresher++;
                if (countFresher == 1) {
                    System.out.println("========Fresher Candidate========");
                }
                System.out.println(candidate.getFname()+" "+candidate.getLname());
            }
            if (candidate instanceof Internship) {
                countIntern++;
                if (countIntern == 1) {
                    System.out.println("=======Internship Candidate========");
                }
                System.out.println(candidate.getFname()+" "+candidate.getLname());
            }
        }
    }
}
