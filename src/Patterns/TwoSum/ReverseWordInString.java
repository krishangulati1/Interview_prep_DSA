package Patterns.TwoSum;

import java.util.Arrays;

/**
 * Utility class for reversing the order of words in a sentence.
 * <p>
 * Example: "the sky is blue" → "blue is sky the"
 * <p>
 * Note: This reverses word ORDER, not the characters within each word.
 */
public class ReverseWordInString {

    /**
     * Reverses the order of words in a given sentence.
     * <p>
     * Approach:
     * 1. Trim leading/trailing whitespace from the sentence.
     * 2. Split the sentence into words using a single space as the delimiter.
     * 3. Use the two-pointer technique to swap words from opposite ends
     *    of the array, moving inward until the pointers meet.
     * 4. Join the reversed array of words back into a single string.
     *
     * @param sentence the input sentence whose word order should be reversed
     * @return a new string with the words in reverse order
     *
     * Time Complexity: O(n), where n is the number of characters in the sentence
     * Space Complexity: O(n), for storing the split words array
     *
     * Caution: This simple split(" ") approach assumes words are separated
     * by single spaces. Multiple consecutive spaces between words will
     * produce empty strings in the array, which can lead to unexpected output.
     * For robustness, consider splitting on "\\s+" instead.
     */
    public static String reverseWord(String sentence) {
        sentence = sentence.trim();

        String[] words = sentence.split(" ");
        int left = 0, right = words.length - 1;

        // Two-pointer swap: exchange words from outside in
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }
        return String.join(" ", words);
    }


    public static void main(String[] args) {
        String[] inputs = {
                "the sky is blue",
                "  hello world  ",
                "a good   example",
                "single",
                ""
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tOriginal: \"" + inputs[i] + "\"");
            String reversed = ReverseWordInString.reverseWord(inputs[i]);
            System.out.println("\tReversed: \"" + reversed + "\"");
            System.out.println("-".repeat(100));
        }
    }
}