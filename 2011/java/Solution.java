import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "--X", "X++", "X++" }, 1),
                new TestCase(new String[] { "++X", "++X", "X++" }, 3),
                new TestCase(new String[] { "X++", "++X", "--X", "X--" }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.finalValueAfterOperations(test.in);
            assert test.expected == actual : "finalValueAfterOperations(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if ("++X".equals(op) || "X++".equals(op)) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

}