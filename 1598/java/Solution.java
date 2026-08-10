import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "d1/", "d2/", "../", "d21/", "./" }, 2),
                new TestCase(new String[] { "d1/", "d2/", "./", "d3/", "../", "d31/" }, 3),
                new TestCase(new String[] { "d1/", "../", "../", "../" }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in);
            assert test.expected == actual : "minOperations(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                depth = Math.max(depth - 1, 0);
            } else if (!"./".equals(log)) {
                depth++;
            }
        }
        return depth;
    }

}