public class Rectangle {
    private double length = 1.0;
    private double width = 1.0;

    public Rectangle() {
        // Default constructor
    }

    public Rectangle(double length, double width) {
        setLength(length);
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (isValidDimension(length)) {
            this.length = length;
        } else {
            System.out.println("Invalid length. Using default value.");
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (isValidDimension(width)) {
            this.width = width;
        } else {
            System.out.println("Invalid width. Using default value.");
        }
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public double calculateArea() {
        return length * width;
    }

    private boolean isValidDimension(double dimension) {
        return dimension > 0.0 && dimension < 20.0;
    }
}
