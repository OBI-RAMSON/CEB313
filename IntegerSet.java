import java.util.Arrays;

public class IntegerSet {
    private boolean[] set;

    public IntegerSet() {
        set = new boolean[101]; // Assuming the set can contain integers from 0 to 100
        Arrays.fill(set, false); // Initialize all elements to false (empty set)
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{ ");

        for (int i = 0; i < set.length; i++) {
            if (set[i]) {
                result.append(i).append(" ");
            }
        }

        result.append("}");
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerSet emptySet = new IntegerSet();
        System.out.println("Empty Set: " + emptySet);

        // You can now manipulate the set by inserting or deleting elements as needed.
        // Example:
        emptySet.insertElement(5);
        emptySet.insertElement(10);
        System.out.println("Updated Set: " + emptySet);

        emptySet.deleteElement(5);
        System.out.println("Set after deleting 5: " + emptySet);
    }

    public void insertElement(int element) {
        if (isValidIndex(element)) {
            set[element] = true;
        } else {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    public void deleteElement(int element) {
        if (isValidIndex(element)) {
            set[element] = false;
        } else {
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= 100; // Assuming the set can contain integers from 0 to 100
    }
}
