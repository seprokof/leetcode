import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abcde", 5),
                new TestCase("xyzxyzxyzxyz", 12),
                new TestCase("aabbccddeeffgghhiiiiii", 24)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumPushes(test.in);
            assert test.expected == actual : "minimumPushes('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for (int i = 0; i < word.length(); i++) {
            frequency[word.charAt(i) - 'a']++;
        }
        Arrays.sort(frequency);
        int result = 0;
        for (int i = 25, j = 0; i >= 0; i--) {
            result += frequency[i] * ((25 - i) / 8 + 1);
        }
        return result;
    }

}