package J1LP0022.model;
/**
 * Uyen Nguyễn
 * */
public class Experience extends Candidate {
private int yearExperience;
private String professinalSkill;
public Experience(){
    super();
}

    public Experience(String id, String fname, String lname, int birth, String address, String phone, String email, int typeCadidate, int yearExperience, String professinalSkill) {
        super(id, fname, lname, birth, address, phone, email, typeCadidate);
        this.yearExperience = yearExperience;
        this.professinalSkill = professinalSkill;
    }


    public Experience(int yearExperience, String professinalSkill) {
        this.yearExperience = yearExperience;
        this.professinalSkill = professinalSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessinalSkill() {
        return professinalSkill;
    }

    public void setProfessinalSkill(String professinalSkill) {
        this.professinalSkill = professinalSkill;
    }


}
