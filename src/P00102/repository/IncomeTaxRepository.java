
package P00102.repository;

import P00102.dataAccess.IncomeTaxDao;
import java.util.List;
import P00102.model.Children;
import P00102.model.Parent;
import P00102.model.Person;

/**
 *
 * @author Neyu
 */
public class IncomeTaxRepository implements IIncomeTaxRepository {
    @Override
    public void inputData(Person person, List<Children> childrens, List<Parent> parents){
        IncomeTaxDao.Instance().inputData(person, childrens, parents);
    }
    
    @Override
    public void detailOfDeduction(Person person, List<Children> childrens, List<Parent> parents){
        IncomeTaxDao.Instance().detailOfDeduction(person, childrens, parents);
    }
}
