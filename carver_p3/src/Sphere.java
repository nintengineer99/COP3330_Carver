// library import
import java.lang.Math;

// sphere class
public class Sphere extends Shape3D {
    // create a sphere object
    public double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return ((4.0 / 3.0) * Math.PI * (radius * radius * radius));
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return (4 * Math.PI * (radius * radius));
    }
}