package P00101.Controller;

import P00101.Model.Truck;
import P00101.Model.repository.HouseHoldRepository;
import P00101.validate.Validator;

public class UyenProgram {
    Validator valid;
    HouseHoldRepository hhr;
    Truck truck;

    public UyenProgram(){
        valid = new Validator();
        hhr = new HouseHoldRepository();
        truck = new Truck();
    }

    public void run(){
        System.out.println("===== Collecting Household Waste ====");
        hhr.calculateTime(truck);
        hhr.calculateCost(truck);

    }
}
