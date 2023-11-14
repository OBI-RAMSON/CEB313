import java.util.Arrays;

public class HugeInteger {
    private int[] digits;

    public HugeInteger() {
        digits = new int[40];
    }

    public void parse(String number) {
        if (number.length() > 40) {
            throw new IllegalArgumentException("Input exceeds maximum length of 40 digits.");
        }

        for (int i = 0; i < number.length(); i++) {
            digits[i] = Character.getNumericValue(number.charAt(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }
        return result.toString();
    }

    public void add(HugeInteger other) {
        // Implementation for addition
        // ...
    }

    public void subtract(HugeInteger other) {
        // Implementation for subtraction
        // ...
    }

    public boolean isEqualTo(HugeInteger other) {
        return Arrays.equals(this.digits, other.digits);
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return !isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other) {
        // Implementation for greater than comparison
        // ...
    }

    public boolean isLessThan(HugeInteger other) {
        // Implementation for less than comparison
        // ...
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        // Implementation for greater than or equal to comparison
        // ...
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {
        // Implementation for less than or equal to comparison
        // ...
    }

    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }

}