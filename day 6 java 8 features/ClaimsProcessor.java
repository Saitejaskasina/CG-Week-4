import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimId, policyNumber, status;
    double claimAmount;

    Claim(String claimId, String policyNumber, String status, double claimAmount) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.status = status;
        this.claimAmount = claimAmount;
    }
}

public class ClaimsProcessor {
    public static void analyzeClaims(List<Claim> claims) {
        Map<String, Double> claimStats = claims.stream()
            .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(c -> c.policyNumber,
                Collectors.summingDouble(c -> c.claimAmount)));

        claimStats.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(3)
            .forEach(entry -> System.out.println(entry.getKey() + " - $" + entry.getValue()));
    }

    public static void main(String[] args) {
        List<Claim> claims = List.of(
            new Claim("C1", "P100", "Approved", 8000),
            new Claim("C2", "P200", "Approved", 12000),
            new Claim("C3", "P300", "Denied", 4000)
        );

        analyzeClaims(claims);
    }
}