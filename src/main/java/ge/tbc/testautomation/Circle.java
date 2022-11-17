package ge.tbc.testautomation;

public class Circle implements Comparable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "ge.tbc.testautomation.Circle{" +
                "radius=" + radius +
                '}';
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Object o) {
        Circle cr = (Circle) o;
        return -1 * Double.compare(this.radius, cr.getRadius());
    }
}
