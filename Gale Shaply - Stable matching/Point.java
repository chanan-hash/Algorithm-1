/**
 * The class is defined by two double variables
 */

public class Point {

    static int counter = 0;

    // variables
    private double x;
    private double y;

    // constructors

    public Point() {
        this.x = 0;
        this.y = 0;
        counter++;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        counter++;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
        counter++;
    }

    // functions

    public void move(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void vector(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println(p1);
        Point p2 = new Point(4, 5);
        Point p3 = new Point(p2);
        p3.x = 2;
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(Point.counter);



    }

}
