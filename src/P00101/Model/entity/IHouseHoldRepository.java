package P00101.Model.entity;

import P00101.Model.Truck;

public interface IHouseHoldRepository {
    void calculateCost(Truck truck);

    void calculateTime(Truck truck);
}
