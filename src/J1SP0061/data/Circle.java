package J1SP0061.data;

public class Circle extends Shape {
    private double r;



    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * r;
    }

    @Override
    public void printResult() {
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + this.r);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }


}
