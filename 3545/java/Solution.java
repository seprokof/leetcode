import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("abc", 2, 1),
                new TestCase("aabb", 2, 0),
                new TestCase("yyyzz", 1, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minDeletion(test.in1, test.in2);
            assert test.expected == actual : "minDeletion('%s', %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int minDeletion(String s, int k) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        Arrays.sort(frequency);
        int result = 0;
        for (int i = 0; i < 26 - k; i++) {
            result += frequency[i];
        }
        return result;
    }

}