/**
 * ============================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 *
 * The palindrome logic is encapsulated inside a
 * PalindromeChecker class.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @author Developer
 * @version 11.0
 */
public class UseCase11PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String input = "racecar";
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        boolean isPalindrome = palindromeChecker.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeChecker {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input input text string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }

        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
