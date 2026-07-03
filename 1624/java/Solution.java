import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("aa", 0),
                new TestCase("abca", 2),
                new TestCase("cbzxy", -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxLengthBetweenEqualCharacters(test.in);
            assert test.expected == actual : "maxLengthBetweenEqualCharacters('%s') == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstPos = new int[26];
        Arrays.fill(firstPos, -1);
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (firstPos[idx] >= 0) {
                result = Math.max(result, i - firstPos[idx] - 1);
            } else {
                firstPos[idx] = i;
            }
        }
        return result;
    }

}