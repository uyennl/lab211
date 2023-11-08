
package P00102.repository;

import java.util.List;
import P00102.model.Children;
import P00102.model.Parent;
import P00102.model.Person;

/**
 *
 * @author Neyu
 */
public interface IIncomeTaxRepository {

    void detailOfDeduction(Person person, List<Children> childrens, List<Parent> parents);

    void inputData(Person person, List<Children> childrens, List<Parent> parents);
    
}
