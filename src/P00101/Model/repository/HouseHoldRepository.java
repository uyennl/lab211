package P00101.Model.repository;

import P00101.Controller.HouseHoldManagement;
import P00101.Model.Truck;
import P00101.Model.entity.IHouseHoldRepository;

public class HouseHoldRepository implements IHouseHoldRepository {
    @Override
    public void calculateCost(Truck truck) {
        HouseHoldManagement.Instance().calculateCost(truck);
    }

    @Override
    public void calculateTime(Truck truck) {
        HouseHoldManagement.Instance().calculateTime(truck);
    }
}
