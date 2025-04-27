import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId, name, policyType;
    int age;
    double premiumAmount;

    PolicyHolder(String holderId, String name, String policyType, int age, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.policyType = policyType;
        this.age = age;
        this.premiumAmount = premiumAmount;
    }
}

public class RiskAssessmentProcessor {
    public static void assessRisk(List<PolicyHolder> holders) {
        Map<String, List<PolicyHolder>> categorizedHolders = holders.stream()
            .filter(h -> h.policyType.equals("Life") && h.age > 60)
            .collect(Collectors.groupingBy(h -> (h.premiumAmount / h.age > 0.5) ? "High Risk" : "Low Risk"));

        System.out.println(categorizedHolders);
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = List.of(
            new PolicyHolder("H1", "John", "Life", 65, 40000),
            new PolicyHolder("H2", "Alice", "Health", 70, 30000)
        );

        assessRisk(holders);
    }
}