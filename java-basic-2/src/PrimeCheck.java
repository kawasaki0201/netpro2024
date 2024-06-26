import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeCheck {

    public static void main(String[] args) {
        int number = 100000;
        List<Integer> primes = findPrimes(number);
        Map<Integer, List<Integer>> primeGroups = groupPrimesByLastDigit(primes);
        printPrimeGroups(primeGroups);
        Map<String, Integer> consecutiveLastDigitPairs = countConsecutiveLastDigitPairs(primes);
        printConsecutiveLastDigitPairRanking(consecutiveLastDigitPairs);
    }

    public static List<Integer> findPrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[number + 1];
        Arrays.fill(isPrime, true);

        for (int p = 2; p <= number; p++) {
            if (isPrime[p]) {
                primes.add(p);
                for (int i = p * 2; i <= number; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return primes;
    }

    public static Map<Integer, List<Integer>> groupPrimesByLastDigit(List<Integer> primes) {
        Map<Integer, List<Integer>> primeGroups = new HashMap<>();
        for (int prime : primes) {
            int lastDigit = prime % 10;
            primeGroups.computeIfAbsent(lastDigit, k -> new ArrayList<>()).add(prime);
        }
        return primeGroups;
    }

    public static void printPrimeGroups(Map<Integer, List<Integer>> primeGroups) {
        System.out.println("素数一覧:");
        for (Map.Entry<Integer, List<Integer>> entry : primeGroups.entrySet()) {
            System.out.println("下一桁が" + entry.getKey() + "の素数:" + entry.getValue());
        }
    }

    public static Map<String, Integer> countConsecutiveLastDigitPairs(List<Integer> primes) {
        Map<String, Integer> consecutiveLastDigitPairs = new HashMap<>();
        int previousPrime = -1;
        for (int prime : primes) {
            if (previousPrime != -1) {
                String pair = previousPrime % 10 + "-" + prime % 10;
                consecutiveLastDigitPairs.put(pair, consecutiveLastDigitPairs.getOrDefault(pair, 0) + 1);
            }
            previousPrime = prime;
        }
        return consecutiveLastDigitPairs;
    }

    public static void printConsecutiveLastDigitPairRanking(Map<String, Integer> consecutiveLastDigitPairs) {
        System.out.println("\n連続する素数の下一桁の出現回数ランキング:");
        List<Map.Entry<String, Integer>> list = new ArrayList<>(consecutiveLastDigitPairs.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ",回数:" + entry.getValue());
        }
    }
}
