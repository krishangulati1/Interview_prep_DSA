package Patterns.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * StrobogrammaticChecker
 * -----------------------
 * Checks whether a given numeric string is "strobogrammatic" —
 * i.e., it looks the same when rotated 180 degrees.
 *
 * Valid rotatable digit pairs: 0-0, 1-1, 8-8, 6-9, 9-6
 *
 * Example: "609" -> rotated -> "609" (strobogrammatic)
 */
public class StrobogrammaticChecker {

    // Function to check if a number is strobogrammatic
    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('8', '8');
        dict.put('6', '9');
        dict.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            if (!dict.containsKey(leftChar) || dict.get(leftChar) != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        String[] nums = {
                "609",
                "88",
                "962",
                "101",
                "123"
        };

        int i = 0;
        for (String num : nums) {
            System.out.println((i + 1) + ".\tnum: " + num);
            System.out.println("\n\tIs strobogrammatic: " + (isStrobogrammatic(num) ? "true" : "false"));
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }
    }
}