import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[][] in3, int expected) {}

        TestCase[] tests = {
                new TestCase(3, 3, new int[][] { { 2, 2}, { 3, 3 } }, 4),
                new TestCase(3, 3, new int[][] { { 2, 2}, { 3, 3 }, { 3, 3 }, { 3, 3 }, { 2, 2 }, { 3, 3 }, { 3, 3 }, { 3, 3 }, { 2, 2 }, { 3, 3 }, { 3, 3 }, { 3, 3 } }, 4),
                new TestCase(3, 3, new int[][] { }, 9)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxCount(test.in1, test.in2, test.in3);
            assert test.expected == actual : "maxCount(%s, %s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    Arrays.deepToString(test.in3), actual, test.expected);
        }
    }

    public int maxCount(int m, int n, int[][] ops) {
        int minX = m;
        int minY = n;
        for (int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        return minX * minY;
    }

}