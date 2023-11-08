
package P00102.model;
/**
 *
 * @author Neyu
 */
public class Children implements Comparable<Children>{
    private int age;
    private int isStudying;
    private int deduction;

    public Children() {
    }

    public Children(int age, int isStudying, int deduction) {
        this.age = age;
        this.isStudying = isStudying;
        this.deduction = deduction;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIsStudying() {
        return isStudying;
    }

    public void setIsStudying(int isStudying) {
        this.isStudying = isStudying;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    @Override
    public int compareTo(Children o) {
        return this.deduction - o.deduction;   
    }  
}
