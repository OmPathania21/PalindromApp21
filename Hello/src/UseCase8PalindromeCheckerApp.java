/**
 * ============================================================
 * MAIN CLASS - UseCase8PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 8: Linked List Based Palindrome Checker
 *
 * Description:
 * This class checks whether a string is a palindrome
 * using a singly linked list.
 *
 * At this stage, the application:
 * - Converts string to singly linked list
 * - Finds the middle using fast and slow pointers
 * - Reverses the second half in place
 * - Compares first and second halves
 *
 * This demonstrates in-place linked-list based validation.
 *
 * @author Developer
 * @version 8.0
 */
public class UseCase8PalindromeCheckerApp {

    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    /**
     * Application entry point for UC8.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        String input = "level";
        Node head = buildLinkedList(input);

        boolean isPalindrome = isPalindrome(head);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }

    private static Node buildLinkedList(String input) {
        Node head = null;
        Node tail = null;

        for (char character : input.toCharArray()) {
            Node newNode = new Node(character);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfStart = (fast == null) ? slow : slow.next;
        Node reversedSecondHalf = reverse(secondHalfStart);

        Node firstPointer = head;
        Node secondPointer = reversedSecondHalf;

        while (secondPointer != null) {
            if (firstPointer.data != secondPointer.data) {
                return false;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return true;
    }

    private static Node reverse(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}
