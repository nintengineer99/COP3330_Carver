// Jacob Carver
// COP 3330
// Programming Assignment 3

import java.util.Scanner;

public class App {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Square square = new Square(0);
        Triangle triangle = new Triangle(0, 0);
        Circle circle = new Circle(0);
        Cube cube = new Cube(0);
        Pyramid pyramid = new Pyramid(0, 0, 0);
        Sphere sphere = new Sphere(0);

        getUserSquare(square);
        getUserTriangle(triangle);
        getUserCircle(circle);
        getUserCube(cube);
        getUserPyramid(pyramid);
        getUserSphere(sphere);
        displayCalculations(square, triangle, circle, cube, pyramid, sphere);
    }

    private static void getUserSquare(Square square) {
        System.out.print("Enter a side length for your square: ");
        square.length = in.nextDouble();
    }

    private static void getUserTriangle(Triangle triangle) {
        System.out.print("Enter a base length for your triangle: ");
        triangle.base = in.nextDouble();
        System.out.print("Enter a height for your triangle: ");
        triangle.height = in.nextDouble();
    }

    private static void getUserCircle(Circle circle) {
        System.out.print("Enter a radius for your circle: ");
        circle.radius = in.nextDouble();
    }

    private static void getUserCube(Cube cube) {
        System.out.print("Enter a side length for your cube: ");
        cube.length = in.nextDouble();
    }

    private static void getUserPyramid(Pyramid pyramid) {
        System.out.print("Enter a base length for your pyramid: ");
        pyramid.baseLength = in.nextDouble();
        System.out.print("Enter a base width for your pyramid: ");
        pyramid.baseWidth = in.nextDouble();
        System.out.print("Enter a height for your pyramid: ");
        pyramid.height = in.nextDouble();
    }

    private static void getUserSphere(Sphere sphere) {
        System.out.print("Enter a radius for your sphere: ");
        sphere.radius = in.nextDouble();
    }

    private static void displayCalculations(Square square, Triangle triangle, Circle circle, Cube cube,
                                            Pyramid pyramid, Sphere sphere) {
        System.out.println("Your square's area is " + square.getArea());
        System.out.println("Your triangle's area is " + triangle.getArea());
        System.out.println("Your circle's area is " + circle.getArea());
        System.out.println("Your cube's surface area is " + cube.getArea());
        System.out.println("Your cube's volume is " + cube.getVolume());
        System.out.println("Your pyramid's surface area is " + pyramid.getArea());
        System.out.println("Your pyramid's volume is " + pyramid.getVolume());
        System.out.println("Your sphere's surface area is " + sphere.getArea());
        System.out.println("Your sphere's volume is " + sphere.getVolume());
    }
}
