/**
 * ============================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements Stack and Deque based strategies
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * @author Developer
 * @version 12.0
 */
public class UseCase12PalindromeCheckerApp {

    /**
     * Application entry point for UC12.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String input = "level";

        // Runtime strategy injection.
        PalindromeStrategy strategy;
        if (args.length > 0 && "deque".equalsIgnoreCase(args[0])) {
            strategy = new DequeStrategy();
        } else {
            strategy = new StackStrategy();
        }

        boolean isPalindrome = strategy.check(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

/**
 * ============================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================
 *
 * Contract for all palindrome checking algorithms.
 */
interface PalindromeStrategy {

    /**
     * Validates whether the given input is a palindrome.
     *
     * @param input string to validate
     * @return true if palindrome, false otherwise
     */
    boolean check(String input);
}

/**
 * ============================================================
 * CLASS - StackStrategy
 * ============================================================
 *
 * Stack based palindrome validation.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using Stack.
     *
     * @param input string to validate
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {
        if (input == null) {
            return false;
        }

        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }

        return true;
    }
}

/**
 * ============================================================
 * CLASS - DequeStrategy
 * ============================================================
 *
 * Deque based palindrome validation.
 */
class DequeStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using Deque.
     *
     * @param input string to validate
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {
        if (input == null) {
            return false;
        }

        java.util.Deque<Character> deque = new java.util.ArrayDeque<Character>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}
