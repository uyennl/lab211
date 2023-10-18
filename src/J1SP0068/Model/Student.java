package J1SP0068.Model;

public class Student {
    private String name;
    private float marks;
    private String classes;

    public Student() {
    }

    public Student(String name, float marks, String classes) {
        this.name = name;
        this.marks = marks;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return
        "\nName: " + name +
        "\nClasses: " + classes+
        "\nMark: " + marks;
    }
}
