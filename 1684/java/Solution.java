import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase("ab", new String[] { "ad", "bd", "aaab", "baa", "badab" }, 2),
                new TestCase("abc", new String[] { "a", "b", "c", "ab", "ac", "bc", "abc" }, 7),
                new TestCase("cad", new String[] { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countConsistentStrings(test.in1, test.in2);
            assert test.expected == actual : "countConsistentStrings('%s', %s) = %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] available = new boolean[26];
        for (char letter : allowed.toCharArray()) {
            available[letter - 'a'] = true;
        }
        int result = 0;
        for (String word : words) {
            if (isConsistent(word, available)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isConsistent(String word, boolean[] availableLetters) {
        for (char letter : word.toCharArray()) {
            if (!availableLetters[letter - 'a']) {
                return false;
            }
        }
        return true;
    }

}