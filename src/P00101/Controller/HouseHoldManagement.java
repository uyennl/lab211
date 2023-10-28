package P00101.Controller;

import P00101.validate.Validator;
import P00101.Model.Truck;
public class HouseHoldManagement {
    private static HouseHoldManagement instance = null;
    private static Validator valid = new Validator();

    public static HouseHoldManagement Instance() {
        if (instance == null) {
            synchronized (HouseHoldManagement.class) {
                if (instance == null) {
                    instance = new HouseHoldManagement();
                }
            }
        }
        return instance;
    }

    public void calculateTime(Truck truck) {
        String s = valid.inputString("Enter the amount of garbage at each station");
        String[] garbages = s.split(" ");
        int total = 0;
        int time = 0;
        int number = 0;
        for (String garbage : garbages) {
            try {
                if (total + Integer.parseInt(garbage) > 10000) {
                    garbage = remainingAmountOfTrash(total, garbage);
                    total = 0;
                    time = time + 8 + 30;
                    number++;
                }
                total = total + Integer.parseInt(garbage);
                time = time + 8;
            } catch (NumberFormatException e) {
                System.err.println(garbage + " is not a numeric");
            }
        }
        System.out.println("Time: " + time);
        System.out.println("Number of Truck: " + number);
        truck.setTime(time + 30);
        truck.setCount(number + 1);
    }

    public String remainingAmountOfTrash(int total, String garbage) {
        int leftover_garbage = (total + Integer.parseInt(garbage) - 10000);
        System.out.println("Amount òf trash: " + leftover_garbage);
        return String.valueOf(leftover_garbage);
    }

    public void calculateCost(Truck truck) {
        int cost = (truck.getTime() * 120000) / 60 + (truck.getCount() * 57000);
        System.out.println("Cost: " + cost);
        truck.setCost(cost);
    }
}
