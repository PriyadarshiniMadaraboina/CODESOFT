import java.util.Scanner;

public class Task4 {

    // Offline exchange rates (safe for VS Code / no internet needed)
    public static double getExchangeRate(String base, String target) {

        if (base.equals("USD") && target.equals("INR")) return 83.2;
        if (base.equals("INR") && target.equals("USD")) return 0.012;

        if (base.equals("EUR") && target.equals("INR")) return 90.0;
        if (base.equals("INR") && target.equals("EUR")) return 0.011;

        if (base.equals("USD") && target.equals("EUR")) return 0.92;
        if (base.equals("EUR") && target.equals("USD")) return 1.08;

        if (base.equals(target)) return 1;

        return -1; // invalid conversion
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Currency selection
        System.out.print("Enter Base Currency (USD, INR, EUR): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter Target Currency (USD, INR, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // Amount input
        System.out.print("Enter Amount to Convert: ");
        double amount = scanner.nextDouble();

        // Get rate
        double rate = getExchangeRate(baseCurrency, targetCurrency);

        // Output
        if (rate == -1) {
            System.out.println("Invalid currency conversion!");
        } else {
            double result = amount * rate;

            System.out.println("\n===== Conversion Result =====");
            System.out.println(amount + " " + baseCurrency +
                    " = " + result + " " + targetCurrency);
        }

        scanner.close();
    }
}