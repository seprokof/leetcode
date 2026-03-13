import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "pay", "attention", "practice", "attend" }, "at", 2),
                new TestCase(new String[] { "leetcode", "win", "loops", "success" }, "code", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.prefixCount(test.in1, test.in2);
            assert test.expected == actual : "prefixCount(%s, '%s') = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }

}