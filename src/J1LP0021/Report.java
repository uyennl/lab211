package J1LP0021;

/**
 * @author UyenNguyễn
 */
public class Report {
    private String name;
    private String course;
    private float totalCourse;

    public Report(String name, String course, float totalCourse) {
        this.name = name;
        this.course = course;
        this.totalCourse = totalCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(float totalCourse) {
        this.totalCourse = totalCourse;
    }
}
