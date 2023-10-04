package J1SP0051;

import J1SP0051.validate.Input;

public class Calculator {
    Input input = new Input();

    public int mennu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        int choice = input.enterInt("Your Choice: ", 1, 3);
        return choice;
    }
    public void displayMenu(){
        while (true) {
            int choice = mennu();
            switch (choice) {
                case 1:
                    nomalCalculator();
                    break;
                case 2:
                    BMICalculator();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void nomalCalculator() {
        double memory = input.enterDouble("number");
        while (true) {
            String operator = input.checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += input.enterDouble("number");
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= input.enterDouble("number");
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= input.enterDouble("number");
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= input.enterDouble("number");
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, input.enterDouble("number"));
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }


    }
    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat-should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }

    //allow user BMI calculator
    public void BMICalculator() {
        double weight = input.enterDouble("Weight(kg)");
        double height = input.enterDouble("Height(cm)");
        double bmi = weight*10000 / (height*height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }

}
