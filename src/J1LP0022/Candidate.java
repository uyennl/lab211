package J1LP0022;
/**
 * Uyen Nguyễn
 * */
public class Candidate {
    private String id;
    private String fname;
    private String lname;
    private int birth;
    private String address;
    private String phone;
    private String email;
    private int typeCadidate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeCadidate() {
        return typeCadidate;
    }

    public void setTypeCadidate(int typeCadidate) {
        this.typeCadidate = typeCadidate;
    }

    public Candidate(String id, String fname, String lname, int birth, String address, String phone, String email, int typeCadidate) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.typeCadidate = typeCadidate;
    }
    public Candidate(){

    }

    @Override
    public String toString() {
         return this.fname + this.lname + "|" + this.birth + "|"
                + this.address + "|" + this.phone + "|" + this.email + "|"
                + this.typeCadidate;
    }
}
