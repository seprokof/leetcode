import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 10, 15, 20 }, 15),
                new TestCase(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }, 6)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minCostClimbingStairs(test.in);
            assert test.expected == actual : "minCostClimbingStairs(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int minCostClimbingStairs(int[] cost) {
        int current = 0;
        int previous = 0;
        for (int i = 1; i < cost.length; i++) {
            int temp = current;
            current = Math.min(cost[i] + current, cost[i - 1] + previous);
            previous = temp;
        }
        return current;
    }

}