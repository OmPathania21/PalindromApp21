import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses multiple palindrome strategy implementations
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses on algorithm comparison
 * using nanosecond-level timing.
 *
 * @author Developer
 * @version 13.0
 */
public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String input = "level";

        PalindromeStrategy[] strategies = {
            new TwoPointerStrategy(),
            new StackStrategy(),
            new DequeStrategy()
        };

        System.out.println("Input : " + input);

        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean isPalindrome = strategy.check(input);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            System.out.println("Strategy : " + strategy.name());
            System.out.println("Is Palindrome? : " + isPalindrome);
            System.out.println("Execution Time : " + executionTime + " ns");
        }
    }
}

/**
 * Contract for palindrome checking strategies.
 */
interface PalindromeStrategy {
    boolean check(String input);

    String name();
}

/**
 * Two pointer based palindrome checker.
 */
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public String name() {
        return "TwoPointerStrategy";
    }
}

/**
 * Stack based palindrome checker.
 */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (char character : input.toCharArray()) {
            stack.push(character);
        }

        for (char character : input.toCharArray()) {
            if (character != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public String name() {
        return "StackStrategy";
    }
}

/**
 * Deque based palindrome checker.
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char character : input.toCharArray()) {
            deque.addLast(character);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    public String name() {
        return "DequeStrategy";
    }
}
