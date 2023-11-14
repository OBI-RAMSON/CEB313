public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

        // Ensure the sign is in the numerator
        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static Rational add(Rational rational1, Rational rational2) {
        int resultNumerator = rational1.numerator * rational2.denominator +
                rational2.numerator * rational1.denominator;
        int resultDenominator = rational1.denominator * rational2.denominator;

        return new Rational(resultNumerator, resultDenominator);
    }

    public static Rational subtract(Rational rational1, Rational rational2) {
        int resultNumerator = rational1.numerator * rational2.denominator -
                rational2.numerator * rational1.denominator;
        int resultDenominator = rational1.denominator * rational2.denominator;

        return new Rational(resultNumerator, resultDenominator);
    }

    public static Rational multiply(Rational rational1, Rational rational2) {
        int resultNumerator = rational1.numerator * rational2.numerator;
        int resultDenominator = rational1.denominator * rational2.denominator;

        return new Rational(resultNumerator, resultDenominator);
    }

    public static Rational divide(Rational rational1, Rational rational2) {
        if (rational2.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        int resultNumerator = rational1.numerator * rational2.denominator;
        int resultDenominator = rational1.denominator * rational2.numerator;

        return new Rational(resultNumerator, resultDenominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public String toFloatingPointString(int precision) {
        double result = (double) numerator / denominator;
        return String.format("%." + precision + "f", result);
    }

    public static void main(String[] args) {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(3, 4);

        System.out.println("Rational 1: " + rational1);
        System.out.println("Rational 2: " + rational2);

        System.out.println("Addition: " + Rational.add(rational1, rational2));
        System.out.println("Subtraction: " + Rational.subtract(rational1, rational2));
        System.out.println("Multiplication: " + Rational.multiply(rational1, rational2));
        System.out.println("Division: " + Rational.divide(rational1, rational2));

        System.out.println("Floating-point representation of Rational 1: " +
                rational1.toFloatingPointString(2));
    }
}
