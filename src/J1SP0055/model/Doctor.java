package J1SP0055.model;
/**
 * Uyen Nguyễn
 * */
public class Doctor {
    private String name;
    private String specialization;
    private int availability;
    public Doctor(){

    }

    public Doctor(String name, String specialization, int availability) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availability=" + availability +
                '}';
    }
}
