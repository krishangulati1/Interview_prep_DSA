package Patterns.TwoSum;

public class WordAbbreviationCheck {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0, j=0;
        while(i<word.length() && j<abbr.length()) {
            char c = abbr.charAt(j);
            if(Character.isDigit(c)) {
                if(c == '0') {
                    return false;
                }
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j)-'0');
                    j++;
                }
                i += num;
            } else {
                if(word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }


    public static void main(String[] args) {
        WordAbbreviationCheck sol = new WordAbbreviationCheck();

        String[][] testCases = {
                {"substitution", "s10n", "true"},
                {"word", "4", "true"},
                {"hello", "h3o", "true"},
                {"abbreviation", "a]2r0eviati2", "false"},
                {"abcdefg", "a05g", "false"},
        };

        // Iterate through each test case and print results
        for (int idx = 0; idx < testCases.length; idx++) {
            String word = testCases[idx][0];
            String abbr = testCases[idx][1];
            boolean result = sol.validWordAbbreviation(word, abbr);
            System.out.println((idx + 1) + ".\tword: [\"" + word + "\"]");
            System.out.println("\tabbr: \"" + abbr + "\"");
            System.out.println("\tResult: " + result);
            System.out.println("-".repeat(100));
        }
    }
}
