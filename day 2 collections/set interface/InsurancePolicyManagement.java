import java.time.LocalDate;
import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    String policyNumber, policyholderName, coverageType;
    LocalDate expiryDate;
    double premiumAmount;

    InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override public boolean equals(Object obj) {
        if (!(obj instanceof InsurancePolicy)) return false;
        return this.policyNumber.equals(((InsurancePolicy) obj).policyNumber);
    }

    @Override public int hashCode() { return policyNumber.hashCode(); }

    @Override public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    Set<InsurancePolicy> hashSet = new HashSet<>();
    Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    Set<InsurancePolicy> treeSet = new TreeSet<>();

    void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    void displayAllPolicies() { treeSet.forEach(System.out::println); }

    void displayExpiringSoon() {
        LocalDate now = LocalDate.now();
        treeSet.stream()
               .filter(policy -> policy.expiryDate.isBefore(now.plusDays(30)))
               .forEach(System.out::println);
    }

    void displayByCoverageType(String type) {
        treeSet.stream()
               .filter(policy -> policy.coverageType.equalsIgnoreCase(type))
               .forEach(System.out::println);
    }

    void findDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        hashSet.forEach(policy -> policyCount.put(policy.policyNumber, policyCount.getOrDefault(policy.policyNumber, 0) + 1));
        policyCount.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println("Duplicate: " + entry.getKey()));
    }

    void comparePerformance() {
        long start, end;

        start = System.nanoTime();
        new HashSet<>(hashSet).containsAll(hashSet);
        end = System.nanoTime();
        System.out.println("HashSet search time: " + (end - start));

        start = System.nanoTime();
        new LinkedHashSet<>(linkedHashSet).containsAll(linkedHashSet);
        end = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (end - start));

        start = System.nanoTime();
        new TreeSet<>(treeSet).containsAll(treeSet);
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        
        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 5, 15), "Health", 2000));
        system.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2025, 4, 10), "Auto", 1500));
        system.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2025, 6, 20), "Home", 2500));
        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 5, 15), "Health", 2000));

        System.out.println("\nAll Policies:");
        system.displayAllPolicies();

        System.out.println("\nPolicies Expiring Soon:");
        system.displayExpiringSoon();

        System.out.println("\nHealth Policies:");
        system.displayByCoverageType("Health");

        System.out.println("\nDuplicate Policies:");
        system.findDuplicatePolicies();

        System.out.println("\nPerformance Comparison:");
        system.comparePerformance();
    }
}
