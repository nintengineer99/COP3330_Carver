// cube class
public class Cube extends Shape3D {
    // create cube object
    public double length;

    public Cube(double length) {
        this.length = length;
    }

    @Override
    public double getVolume() {
        return (length * length * length);
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return (6 * (length * length));
    }
}