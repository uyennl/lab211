
package P00102.model;

/**
 *
 * @author Neyu
 */
public class Person {
    private String name;
    private int age;
    private int sex;
    private double income;
    private int hasChild;
    private int hasSiblingRegister;
    private int hasParent;
    private int deduction;

    public Person() {
    }

    public Person(String name, int age, int sex, double income, int hasChild, int hasSiblingRegister, int hasParent, int deduction) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.income = income;
        this.hasChild = hasChild;
        this.hasSiblingRegister = hasSiblingRegister;
        this.hasParent = hasParent;
        this.deduction = deduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int isSex() {
        return sex;
    }

    public void setIsSex(int sex) {
        this.sex = sex;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getHasChild() {
        return hasChild;
    }

    public void setHasChild(int hasChild) {
        this.hasChild = hasChild;
    }

    public int getHasSiblingRegister() {
        return hasSiblingRegister;
    }

    public void setHasSiblingRegister(int hasSiblingRegister) {
        this.hasSiblingRegister = hasSiblingRegister;
    }

    public int getHasParent() {
        return hasParent;
    }

    public void setHasParent(int hasParent) {
        this.hasParent = hasParent;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }
    
    
}
