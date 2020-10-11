// triangle class
public class Triangle extends Shape2D {
    // create triangle object

    public double base;
    public double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        return (0.5 * base * height);
    }
}
