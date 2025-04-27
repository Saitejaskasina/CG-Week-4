import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId, policyNumber;
    double amount;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.isFraudulent = isFraudulent;
    }
}

public class FraudProcessor {
    public static void detectFraud(List<Transaction> transactions) {
        Map<String, Long> fraudCounts = transactions.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.groupingBy(t -> t.policyNumber, Collectors.counting()));

        System.out.println(fraudCounts);
    }

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
            new Transaction("T1", "P100", 12000, true),
            new Transaction("T2", "P200", 5000, false)
        );

        detectFraud(transactions);
    }
}