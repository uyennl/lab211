
package P00102.controller;

import P00102.common.Validation;
import java.util.ArrayList;
import java.util.List;
import P00102.model.Children;
import P00102.model.Parent;
import P00102.model.Person;
import P00102.repository.IncomeTaxRepository;
/**
 *
 * @author Neyu
 */
public class IncomeTaxController {
    Validation valid;
    Person person;
    List<Children> childrens;
    List<Parent> parents;
    IncomeTaxRepository repo;

    public IncomeTaxController(){
        valid = new Validation();
        person =  new Person();
        childrens = new ArrayList<>();
        parents = new ArrayList<>();
        repo = new IncomeTaxRepository();
    }
    
    public void run(){
        System.out.println("========Income Tax Program=========");
        repo.inputData(person, childrens, parents);
        repo.detailOfDeduction(person, childrens, parents);
    }
}
