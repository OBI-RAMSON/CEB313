public class RectangleTest {
    public static void main(String[] args) {
        // Test with default values
        Rectangle defaultRectangle = new Rectangle();
        System.out.println("Default Rectangle - Perimeter: " + defaultRectangle.calculatePerimeter());
        System.out.println("Default Rectangle - Area: " + defaultRectangle.calculateArea());

        // Test with custom values
        Rectangle customRectangle = new Rectangle(5.0, 3.0);
        System.out.println("Custom Rectangle - Perimeter: " + customRectangle.calculatePerimeter());
        System.out.println("Custom Rectangle - Area: " + customRectangle.calculateArea());

        // Test with invalid dimensions
        Rectangle invalidRectangle = new Rectangle(25.0, -2.0);
        System.out.println("Invalid Rectangle - Perimeter: " + invalidRectangle.calculatePerimeter());
        System.out.println("Invalid Rectangle - Area: " + invalidRectangle.calculateArea());
    }
}
