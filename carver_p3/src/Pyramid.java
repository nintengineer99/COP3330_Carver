import java.lang.Math;

public class Pyramid extends Shape3D {
    private final double baseLength;
    private final double baseWidth;
    private final double height;

    public Pyramid(double baseLength, double baseWidth, double height) {
        this.baseLength = baseLength;
        this.baseWidth = baseWidth;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return ((baseLength * baseWidth * height) / 3);
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        return ((baseLength * baseWidth)
                + (baseLength * (Math.sqrt(((0.5 * baseWidth) * (0.5 * baseWidth)) + (height * height))))
                + (baseWidth * (Math.sqrt(((0.5 * baseLength) * (0.5 * baseLength)) + (height * height)))));
    }
}
