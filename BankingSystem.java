import java.util.Scanner; 
class BankAccount { 
private String accountNumber; 
private String accountHolder; 
private double balance; 
private double dailyWithdrawalLimit; 
private double amountWithdrawnToday; 
public BankAccount(String accountNumber, String accountHolder, double    
initialBalance, double dailyWithdrawalLimit) { 
this.accountNumber = accountNumber; 
this.accountHolder = accountHolder; 
this.balance = initialBalance; 
this.dailyWithdrawalLimit = dailyWithdrawalLimit; 
this.amountWithdrawnToday = 0; 
} 
// Method to deposit money 
public void deposit(double amount) { 
if (amount > 0) { 
balance += amount; 
System.out.println("Successfully deposited: $" + amount); 
} else { 
System.out.println("Deposit amount must be greater than zero."); 
} 
} 
// Method to withdraw money 
public void withdraw(double amount) { 
if (amount > 0 && amount <= balance) { 
if ((amountWithdrawnToday + amount) <= dailyWithdrawalLimit) { 
balance -= amount; 
amountWithdrawnToday += amount; 
System.out.println("Successfully withdrew: $" + amount); 
} else { 
System.out.println("Withdrawal exceeds daily limit of $" + dailyWithdrawalLimit); 
} 
} else { 
System.out.println("Insufficient balance or invalid amount."); 
} 
} 
// Method to check balance 
public void checkBalance() { 
System.out.println("Current balance: $" + balance); 
} 
// Method to display account information 
public void displayAccountInfo() { 
System.out.println("Account Holder: " + accountHolder); 
System.out.println("Account Number: " + accountNumber); 
System.out.println("Current Balance: $" + balance); 
System.out.println("Daily Withdrawal Limit: $" + dailyWithdrawalLimit); 
    } 
} 
 
public class BankingSystem { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        BankAccount account = new BankAccount("12345678", "John Doe", 
5000, 1000); 
        int choice; 
        do { 
            System.out.println("****We have following Operations on Banking System****");  
            System.out.println("1. Deposit Money"); 
            System.out.println("2. Withdraw Money"); 
            System.out.println("3. Check Balance"); 
            System.out.println("4. Display Account Information"); 
            System.out.println("5. Exit"); 
            System.out.print("Enter your choice: "); 
            choice = scanner.nextInt(); 
 
            switch (choice) { 
                case 1: 
                    System.out.print("Enter amount to deposit: "); 
                    double depositAmount = scanner.nextDouble(); 
                    account.deposit(depositAmount); 
                    break; 
                case 2: 
                    System.out.print("Enter amount to withdraw: "); 
                    double withdrawAmount = scanner.nextDouble(); 
                    account.withdraw(withdrawAmount); 
                    break; 
                case 3: 
                    account.checkBalance(); 
                    break; 
                case 4: 
                    account.displayAccountInfo(); 
                    break; 
                case 5: 
                    System.out.println("Thank You !!!!!!."); 
                    break; 
                default: 
                    System.out.println("Invalid choice! Please try again."); 
            } 
        } while (choice != 5); 
scanner.close(); 
    } 
}