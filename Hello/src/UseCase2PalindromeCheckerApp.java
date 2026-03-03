/**
 * ============================================================
 * MAIN CLASS - UseCase2PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 2: Hardcoded Palindrome Validation
 *
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * At this stage, the application:
 * - Stores a predefined string
 * - Compares characters from both ends
 * - Determines whether the string is a palindrome
 * - Displays the result on the console
 *
 * This use case introduces fundamental comparison logic
 * before using advanced data structures.
 *
 * @author Developer
 * @version 2.0
 */
public class UseCase2PalindromeCheckerApp {

    /**
     * Application entry point for UC2.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String input = "Nurses Run";
        String normalizedInput = input.replaceAll("\\s+", "").toLowerCase();
        boolean isPalindrome = true;

        for (int i = 0; i < normalizedInput.length() / 2; i++) {
            if (normalizedInput.charAt(i) != normalizedInput.charAt(normalizedInput.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}
