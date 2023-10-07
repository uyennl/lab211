package J1SP0050.controller;


import J1SP0050.validate.Input;
import J1SP0050.view.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author UyenNguyễn
 */
public class Manager {
    public Manager() {
    }
    Menu menu = new Menu();


    Input input = new Input();
    final ArrayList<Float> LIST_FLOAT = new ArrayList<>();

    public void getMenu() {
        int choice;
        do {
            menu.displayMenu();
            choice = input.enterInt("", 1, 3);
            switch (choice) {
                case 1:
                    outputEquation(LIST_FLOAT);
                    LIST_FLOAT.clear();
                    break;
                case 2:
                    outputQuadratic(LIST_FLOAT);
                    LIST_FLOAT.clear();
                    break;

            }

        }
        while (choice < 3);
    }

    public void handleOutput(List<Float> listFloat) {
        String outputOdd = "";
        String outputEven = "";
        String outputPerfectNum = "";

        for (float number : listFloat) {
            if (isOdd(number)) {
                outputOdd += number + ",";
            } else {
                outputEven += number + ",";
            }

            if (isPerfectSquare(number)) {
                outputPerfectNum += number + ",";
            }
        }

        if (!outputOdd.isEmpty()) {
            System.out.println("Odd number: "
                    + outputOdd.substring(0, outputOdd.length() - 1));
        }

        if (!outputEven.isEmpty()) {
            System.out.println("Even number: "
                    + outputEven.substring(0, outputEven.length() - 1));
        }

        if (!outputPerfectNum.isEmpty()) {
            System.out.println("Perfect number: "
                    + outputPerfectNum.substring(0, outputPerfectNum.length() - 1));
        }

    }

    public void outputEquation(List<Float> listFloat) {
        System.out.println("--------Caculate Equation---------");
        float a = input.enterFloat("A");
        float b = input.enterFloat("B");
        handleOutput(caculateEquation(listFloat, a, b));
        System.out.println();
    }

    public void outputQuadratic(List<Float> listFloat) {
        System.out.println("---------Caculate Quadratic Equation-------");
        float a = input.enterFloat("A");
        float b = input.enterFloat("B");
        float c = input.enterFloat("C");
        handleOutput(caculateQuadraticEquation(listFloat, a, b, c));
        System.out.println();

    }

    public List<Float> caculateEquation(List<Float> listFloat, float a, float b) {
        listFloat.add(a);
        listFloat.add(b);

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite many solutions!");
                System.out.println("empty");
            } else {
                System.out.println("No solution!");
                System.out.println("null");
            }
        } else {
            float x = -b / a;
            listFloat.add(x);
            System.out.println("Solution: x = " + x);
        }
        return listFloat;
    }

    public List<Float> caculateQuadraticEquation(List<Float> listFloat, float a, float b, float c) {
        float x1, x2;
        final float delta = b * b - 4 * a * c;
        listFloat.add(a);

        if (a == 0) {
            caculateEquation(listFloat, b, c);
        } else {
            listFloat.add(b);
            listFloat.add(c);
            if (delta < 0) {
                System.out.println("No solution!");
            } else if (delta == 0) {
                x1 = -b / (2 * a);
                x2 = x1;
                listFloat.add(x1);
                listFloat.add(x2);
                System.out.println("solution x1 = " + x1 + " and x2 = " + x2);
            } else {
                x1 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
                x2 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
                listFloat.add(x1);
                listFloat.add(x2);
                System.out.println("Equation has 2 different solutions: x1 = " + x1 + " and x2 = " + x2);
            }
        }
        return listFloat;
    }

    public boolean isOdd(float number) {
        return (number % 2) != 0;
    }

    public boolean isPerfectSquare(double number) {
        return Math.sqrt(number) == Math.floor(Math.sqrt(number));
    }
}
