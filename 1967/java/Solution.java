import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "a", "abc", "bc", "d" }, "abc", 3),
                new TestCase(new String[] { "a", "b", "c" }, "aaaaabbbbb", 2),
                new TestCase(new String[] { "a", "a", "a" }, "ab", 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numOfStrings(test.in1, test.in2);
            assert test.expected == actual : "numOfStrings(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int numOfStrings(String[] patterns, String word) {
        int result = 0;
        for (String p : patterns) {
            if (word.contains(p)) {
                result++;
            }
        }
        return result;
    }

}