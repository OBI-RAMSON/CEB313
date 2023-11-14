public class Complex {
    private double realPart;
    private double imaginaryPart;

    // Constructor with initial values
    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // No-argument constructor with default values
    public Complex() {
        this(0.0, 0.0);
    }

    // Method to add two Complex numbers
    public Complex add(Complex other) {
        double resultRealPart = this.realPart + other.realPart;
        double resultImaginaryPart = this.imaginaryPart + other.imaginaryPart;
        return new Complex(resultRealPart, resultImaginaryPart);
    }

    // Method to subtract two Complex numbers
    public Complex subtract(Complex other) {
        double resultRealPart = this.realPart - other.realPart;
        double resultImaginaryPart = this.imaginaryPart - other.imaginaryPart;
        return new Complex(resultRealPart, resultImaginaryPart);
    }

    // Method to print Complex numbers in the form (realPart, imaginaryPart)
    public void printComplex() {
        System.out.printf("(%f, %f)%n", realPart, imaginaryPart);
    }

    public static void main(String[] args) {
        // Example usage
        Complex complex1 = new Complex(2.0, 3.0);
        Complex complex2 = new Complex(1.5, 2.5);

        System.out.print("Complex 1: ");
        complex1.printComplex();

        System.out.print("Complex 2: ");
        complex2.printComplex();

        // Addition
        Complex sum = complex1.add(complex2);
        System.out.print("Sum: ");
        sum.printComplex();

        // Subtraction
        Complex difference = complex1.subtract(complex2);
        System.out.print("Difference: ");
        difference.printComplex();
    }
}
