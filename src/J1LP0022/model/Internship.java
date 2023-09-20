package J1LP0022.model;

import J1LP0022.model.Candidate;

/**
 * Uyen Nguyễn
 * */
public class Internship extends Candidate {
    private String major;
    private String semester;
    private String university;
    public Internship(){
        super();
    }

    public Internship(String id, String fname, String lname, int birth, String address, String phone, String email, int typeCadidate, String major, String semester, String university) {
        super(id, fname, lname, birth, address, phone, email, typeCadidate);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public Internship(String major, String semester, String university) {
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }


}
