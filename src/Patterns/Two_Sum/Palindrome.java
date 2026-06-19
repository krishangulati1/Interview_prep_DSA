package Patterns.Two_Sum;

public class Palindrome {

    public Boolean checkPalindrome(String s) {
        //Use 2 pointer technique to find if the string is Palindrome
        if(s.isEmpty()) return true;

        s = s.toLowerCase();

        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
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
