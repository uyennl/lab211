/**
 *
 * @author Neyu
 */
package P00102.dataAccess;

import P00102.common.Validation;
import java.util.Collections;
import java.util.List;
import P00102.model.Children;
import P00102.model.Parent;
import P00102.model.Person;

/**
 *
 * @author Neyu
 */
public class IncomeTaxDao {
    private static IncomeTaxDao instance = null;
    private static Validation valid = new Validation();
    
    public static IncomeTaxDao Instance(){
        if (instance == null){
            synchronized (IncomeTaxDao.class) {
                if (instance == null){
                    instance = new IncomeTaxDao();
                }
            }
        }
        return instance;
    }
    
    public void inputData(Person person, List<Children> childrens, List<Parent> parents){
        System.out.println("---------Input Person Data----------");
        person.setName(valid.inputString("Enter Name"));
        person.setAge(valid.inputInt("Enter Age", 0, 122));
        person.setIsSex(valid.inputInt("Enter sex( 1:male || 0:female )",0,1));
        person.setIncome(valid.inputDouble("Enter Income", 0));
        person.setHasChild(valid.inputInt("Enter number of children", 0, 15));
        person.setHasParent(valid.inputInt("Enter number of parent", 0, 15));
        person.setHasSiblingRegister(valid.inputInt("Is that person have sibling register ?( 1:yes || 0:no)",0,1));
        
        if (person.getHasChild()>0){
            System.out.println("--------Input Children Data---------");
            inputChilren(childrens, person.getHasChild());
        }
        if (person.getHasSiblingRegister() == 1 && person.getHasParent()>0){
            System.out.println("--------Input Parent Data ----------");
            inputParent(parents, person.getHasParent());
        }
        person.setDeduction(11000000);
    }
    
    public void inputChilren(List<Children> childrens, int hasChild){
        Children children = new Children();
        for (int i=0; i<hasChild; i++){
            System.out.println("Input Child No." + (i+1));
            children.setAge(valid.inputInt("Enter Age", 0, 122));
            children.setIsStudying(valid.inputInt("Is child studying ?( 1:yes || 0:no)",0,1));
            childrens.add(children);
        }
    }
    
    public void inputParent(List<Parent> parents, int hasParent){
        Parent parent = new Parent();
        for (int i=0; i<hasParent; i++){
            System.out.println("Input Parent No." + (i+1));
            parent.setAge(valid.inputInt("Enter Age", 0, 122));
            parent.setIsSex(valid.inputInt("Enter sex( 1:male || 0:female)",0,1));
            parents.add(parent);
        }
    }
    
    public int deductionForChildrens (List<Children> childrens){
        int deduction = 0;
        for (Children children: childrens){
            if (children.getAge() <= 18){
                children.setDeduction(4400000);
            }
            else if (children.getAge() >18 && children.getAge() <=22 && children.getIsStudying() == 1){
                children.setDeduction(6000000);
            }
            else {
                children.setDeduction(0);
            }
        }
        int count =0 ;
        Collections.reverse(childrens);
        for (Children children: childrens){
            deduction = deduction + children.getDeduction();
            count++;
            if(count>=2) break;
        }
        return deduction;
    }
    
    public int deductionForParents (Person person, List<Parent> parents){
        int deduction = 0;
        if (person.getHasSiblingRegister() == 1){
            for (Parent parent : parents){
                if((parent.getSex() == 1 && parent.getAge() >= 60) ||
                        (parent.getSex() == 0 && parent.getAge() >= 55)){
                    parent.setDeduction(4400000);
                    deduction = deduction + parent.getDeduction();
                }
            }
        }
        return deduction;
    }
    
    public int deductionTotal(int deduction_for_children,int deduction_for_parents){
        int deduction = 11000000 + deduction_for_children + deduction_for_parents;
        return deduction;
    }
    
    public int calculateTaxRate(double income,int deduction){
        int taxRate;
        double taxableIncome = income - deduction;
        if (taxableIncome < 4000000){
            taxRate = 5;
        }
        else if (deduction >= 4000000 && deduction < 6000000){
            taxRate = 8;
        }
        else if (deduction >= 6000000 && deduction < 10000000){
            taxRate = 10;
        }
        else {
            taxRate = 20;
        }
        return taxRate;
    }
    
    public double calculateIncomeTax(double income,int deduction, int taxRate){
        double incomeTax = income - deduction;
        if (incomeTax <=0){
            incomeTax = 0;
        }
        incomeTax = incomeTax * 100 / taxRate;
        return incomeTax;
    }
    
    public void detailOfDeduction(Person person, List<Children> childrens, List<Parent> parents){
        System.out.println("--------Detail Of Deduction-------");
        double income = person.getIncome();
        System.out.printf("Total Income: %.2f\n",income);
        
        System.out.println("Deduction for self: " + person.getDeduction());
        
        System.out.print("Deduction for supporting children: ");
        int deduction_for_children = deductionForChildrens(childrens);
        System.out.println(deduction_for_children);
        
        System.out.print("Deduction for supporting parents: ");
        int deduction_for_parents = deductionForParents(person, parents);
        System.out.println(deduction_for_parents);
        
        System.out.print("Deduction total: ");
        int deduction = deductionTotal(deduction_for_children, deduction_for_parents);
        System.out.println(deduction);
         
        System.out.print("Tax rate: ");
        int taxRate = calculateTaxRate(income, deduction);
        System.out.println(taxRate + "%");
        
        double incomeTax = calculateIncomeTax(income, deduction, taxRate);
        System.out.printf("-------------\nThe amount of tax to be paid: %.2f\n",incomeTax);
    }
}
