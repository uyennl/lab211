package J1SP0061.method;

import J1SP0061.data.Circle;
import J1SP0061.data.Rectangle;
import J1SP0061.data.Triangle;

import java.util.Scanner;

public class Input {
    private final Scanner in = new Scanner(System.in);

    private double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public Rectangle inputRec() {
        System.out.print("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    public Circle inputCircle() {
        System.out.printf("Please input radius of Circle:  ");
        double r = checkInputDouble();
        return new Circle(r);
    }

    public Triangle inputTri() {
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Re-input");
            }
        }
    }
    public void display(Triangle tri, Rectangle rec, Circle circle) {
        System.out.println("=====Value=====");
        rec.printResult();
        circle.printResult();
        tri.printResult();
    }
}
