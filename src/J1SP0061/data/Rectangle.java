package J1SP0061.data;

public class Rectangle extends Shape {
    private double w;
    private double l;



    public Rectangle(double w, double l) {
        this.w = w;
        this.l = l;
    }

    @Override
    public double getPerimeter() {
        return (w + l) * 2;
    }

    @Override
    public double getArea() {
        return w * l;

    }

    @Override
    public void printResult() {
        System.out.println("-----Rectangle-----");
        System.out.println("Width:  "+this.w);
        System.out.println("Length:  "+this.l);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }


}
