import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("aaAbcBC", 3),
                new TestCase("abc", 0),
                new TestCase("AbBCab", 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfSpecialChars(test.in);
            assert test.expected == actual : "numberOfSpecialChars('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int numberOfSpecialChars(String word) {
        int[] lastLowerIndex = new int[26];
        Arrays.fill(lastLowerIndex, -1);
        int[] firstUpperIndex = new int[26];
        Arrays.fill(firstUpperIndex, -1);
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter > 'Z') {
                lastLowerIndex[letter - 'a'] = i;
            } else if (firstUpperIndex[letter - 'A'] == -1) {
                firstUpperIndex[letter - 'A'] = i;
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLowerIndex[i] > -1 && firstUpperIndex[i] > lastLowerIndex[i]) {
                result++;
            }
        }
        return result;
    }

}