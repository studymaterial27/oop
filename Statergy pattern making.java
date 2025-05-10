import java.util.*;

public class PaymentApp {

    public interface PaymentStrategy {
        void pay(double amount);
    }

    public static class CreditCardPayment implements PaymentStrategy {
        private String name, cardNumber, cvv, expiryDate;

        public CreditCardPayment(String name, String cardNumber, String cvv, String expiryDate) {
            this.name = name;
            this.cardNumber = cardNumber;
            this.cvv = cvv;
            this.expiryDate = expiryDate;
        }

        public void pay(double amount) {
            System.out.println("You paid " + amount + " using Credit Card.");
        }

        public static PaymentStrategy getDetails() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Card Holder Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Card Number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Enter CVV: ");
            String cvv = scanner.nextLine();
            System.out.print("Enter Expiry Date (MM/YY): ");
            String expiryDate = scanner.nextLine();
            return new CreditCardPayment(name, cardNumber, cvv, expiryDate);
        }
    }

    public static class PayPalPayment implements PaymentStrategy {
        private String email, password;

        public PayPalPayment(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public void pay(double amount) {
            System.out.println("You paid " + amount + " using PayPal.");
        }

        public static PaymentStrategy getDetails() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter PayPal Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter PayPal Password: ");
            String password = scanner.nextLine();
            return new PayPalPayment(email, password);
        }
    }

    public static class BitcoinPayment implements PaymentStrategy {
        private String bitcoinAddress;

        public BitcoinPayment(String bitcoinAddress) {
            this.bitcoinAddress = bitcoinAddress;
        }

        public void pay(double amount) {
            System.out.println("You paid " + amount + " using Bitcoin.");
        }

        public static PaymentStrategy getDetails() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Bitcoin Address: ");
            String address = scanner.nextLine();
            return new BitcoinPayment(address);
        }
    }

    public static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class ShoppingCart {
        private List<Item> items = new ArrayList<>();

        public void addItem(Item item) {
            items.add(item);
        }

        public double calculateTotal() {
            double total = 0;
            for (Item item : items) total += item.getPrice();
            return total;
        }

        public void checkout(PaymentStrategy paymentMethod) {
            double total = calculateTotal();
            paymentMethod.pay(total);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Laptop", 1200.00));
        cart.addItem(new Item("Smartphone", 800.00));
        cart.addItem(new Item("Headphones", 150.00));

        System.out.println("Total Bill: $" + cart.calculateTotal());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Bitcoin");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        PaymentStrategy paymentMethod;
        switch (choice) {
            case 1 -> paymentMethod = CreditCardPayment.getDetails();
            case 2 -> paymentMethod = PayPalPayment.getDetails();
            case 3 -> paymentMethod = BitcoinPayment.getDetails();
            default -> {
                System.out.println("Invalid choice, using default (Credit Card)");
                paymentMethod = CreditCardPayment.getDetails();
            }
        }

        cart.checkout(paymentMethod);
    }
}
//file save as =   PaymentApp.java
//compile commond = javac PaymentApp.java
// run commond= PaymentApp
