import java.util.*;

class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override public String toString() {
        return accountNumber + " | Balance: $" + balance;
    }
}

public class BankingSystem {
    Map<String, Double> accountMap = new HashMap<>();
    TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    Queue<String> withdrawalQueue = new LinkedList<>();

    void addAccount(String accountNumber, double balance) {
        accountMap.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    void withdraw(String accountNumber, double amount) {
        withdrawalQueue.offer(accountNumber + " $" + amount);
    }

    void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            System.out.println("Processing: " + withdrawalQueue.poll());
        }
    }

    void displaySortedAccounts() {
        sortedAccounts.forEach((balance, account) -> System.out.println(account + " - $" + balance));
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("12345", 5000);
        bank.addAccount("67890", 3000);
        bank.addAccount("54321", 7000);

        System.out.println("\nSorted Accounts:");
        bank.displaySortedAccounts();

        bank.withdraw("12345", 1000);
        bank.withdraw("67890", 500);

        System.out.println("\nProcessing Withdrawals:");
        bank.processWithdrawals();
    }
}