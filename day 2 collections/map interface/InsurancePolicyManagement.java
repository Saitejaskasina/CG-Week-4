import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    String policyNumber, policyholderName;
    LocalDate expiryDate;
    double premiumAmount;

    InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    @Override public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    Map<String, InsurancePolicy> hashMap = new HashMap<>();
    Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, InsurancePolicy> treeMap = new TreeMap<>();

    void addPolicy(InsurancePolicy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.expiryDate, policy);
    }

    InsurancePolicy getPolicy(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    void listExpiringSoon() {
        LocalDate now = LocalDate.now();
        treeMap.tailMap(now.plusDays(30), false).forEach((date, policy) -> System.out.println(policy));
    }

    void listPoliciesByHolder(String name) {
        hashMap.values().stream()
               .filter(policy -> policy.policyholderName.equalsIgnoreCase(name))
               .forEach(System.out::println);
    }

    void removeExpiredPolicies() {
        treeMap.headMap(LocalDate.now(), false).clear();
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new InsurancePolicy("P101", "Alice", LocalDate.of(2025, 5, 10), 2000));
        system.addPolicy(new InsurancePolicy("P102", "Bob", LocalDate.of(2025, 4, 5), 1500));
        system.addPolicy(new InsurancePolicy("P103", "Charlie", LocalDate.of(2025, 6, 20), 2500));

        System.out.println("\nRetrieve Policy P101:");
        System.out.println(system.getPolicy("P101"));

        System.out.println("\nPolicies Expiring Soon:");
        system.listExpiringSoon();

        System.out.println("\nPolicies for Alice:");
        system.listPoliciesByHolder("Alice");

        System.out.println("\nRemoving Expired Policies...");
        system.removeExpiredPolicies();
        System.out.println("\nRemaining Policies:");
        system.treeMap.forEach((date, policy) -> System.out.println(policy));
    }
}