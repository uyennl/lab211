
package P00102.model;

/**
 *
 * @author Neyu
 */
public class Parent {
    private int sex;
    private int age;
    private int deduction;

    public Parent() {
    }

    public Parent(int sex, int age, int deduction) {
        this.sex = sex;
        this.age = age;
        this.deduction = deduction;
    }

    public int getSex() {
        return sex;
    }

    public void setIsSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }
    
    
}
