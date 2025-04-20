import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteCount = new HashMap<>();
    LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedResults = new TreeMap<>(Comparator.comparingInt(voteCount::get).reversed());

    void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    void displayResults() {
        sortedResults.putAll(voteCount);
        sortedResults.forEach((candidate, votes) -> System.out.println(candidate + " - " + votes + " votes"));
    }

    void displayVoteOrder() {
        voteOrder.forEach((candidate, votes) -> System.out.println(candidate + " - " + votes + " votes"));
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Alice");
        system.castVote("Bob");

        System.out.println("\nVotes in Order of Casting:");
        system.displayVoteOrder();

        System.out.println("\nSorted Voting Results:");
        system.displayResults();
    }
}