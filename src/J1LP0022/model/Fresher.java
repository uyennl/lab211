package J1LP0022.model;

import J1LP0022.model.Candidate;

/**
 * Uyen Nguyễn
 * */
public class Fresher extends Candidate {
private String graduationDate;
private String getGraduationRank;


public Fresher(){
    super();
}

    public Fresher(String id, String fname, String lname, int birth, String address, String phone, String email, int typeCadidate, String graduationDate, String getGraduationRank) {
        super(id, fname, lname, birth, address, phone, email, typeCadidate);
        this.graduationDate = graduationDate;
        this.getGraduationRank = getGraduationRank;
    }

    public Fresher(String graduationDate, String getGraduationRank) {
        this.graduationDate = graduationDate;
        this.getGraduationRank = getGraduationRank;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGetGraduationRank() {
        return getGraduationRank;
    }

    public void setGetGraduationRank(String getGraduationRank) {
        this.getGraduationRank = getGraduationRank;
    }


}
