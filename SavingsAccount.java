public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
    }

    public static void modifyInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        SavingsAccount.modifyInterestRate(0.04); // Set annualInterestRate to 4%

        System.out.println("Initial balances:");
        displayBalances(saver1, saver2);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nBalances after one month's interest:");
        displayBalances(saver1, saver2);

        SavingsAccount.modifyInterestRate(0.05); // Set annualInterestRate to 5%

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("\nBalances after another month's interest with updated rate:");
        displayBalances(saver1, saver2);
    }

    private static void displayBalances(SavingsAccount... accounts) {
        for (SavingsAccount account : accounts) {
            System.out.printf("Savings Balance: $%.2f%n", account.getSavingsBalance());
        }
    }
}
