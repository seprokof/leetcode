import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, String expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "abc", "car", "ada", "racecar", "cool" }, "ada"),
                new TestCase(new String[] { "notapalindrome", "racecar" }, "racecar"),
                new TestCase(new String[] { "def", "ghi" }, "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.firstPalindrome(test.in);
            assert Objects.equals(test.expected, actual) : "firstPalindrome(%s) = '%s', want '%s'"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String word) {
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}