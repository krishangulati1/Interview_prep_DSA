package Patterns.Two_Sum;

public class Palindrome {

    public Boolean checkPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move left pointer forward if it's on a non-alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                System.out.println("\tSkipping non-alphanumeric at left: '" + s.charAt(left) + "' (index " + left + ")");
                left++;
            }

            // Move right pointer backward if it's on a non-alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                System.out.println("\tSkipping non-alphanumeric at right: '" + s.charAt(right) + "' (index " + right + ")");
                right--;
            }

            System.out.println("\tLeft -> '" + s.charAt(left) + "' (index " + left + "), Right -> '" + s.charAt(right) + "' (index " + right + ")");

            // Move pointers inward
            left++;
            right--;
        }
        return true;
    }

    public static void main(String []args) {
        String testPalindrome = "Madam";
        Palindrome p = new Palindrome();
        System.out.println(p.checkPalindrome(testPalindrome));
    }
}
