// library import
import java.lang.Math;

// circle class
public class Circle extends Shape2D {
    // create circle object
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return (Math.PI * (radius * radius));
    }
}
