import java.util.Scanner;

public class CheckOut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        do {
            double price = SafeInput.getRangedDouble(sc, "Enter price of item ($0.50 - $10.00): ", 0.50, 10.00);
            total += price;
        } while (SafeInput.getYNConfirm(sc, "Do you have more items? (Y/N): "));

        System.out.printf("Total cost: $%.2f%n", total);
        sc.close();
    }
}
