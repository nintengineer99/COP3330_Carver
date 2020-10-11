import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {
    @Test
    public void testSquareName() {
        Shape shape = new Square(10);
        assertEquals("square", shape.getName());
    }
}