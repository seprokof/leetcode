import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 5),
                new TestCase(new int[] { 6, 5, 7, 9, 2, 2 }, 23),
                new TestCase(new int[] { 5, 5 }, 10)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumCost(test.in);
            assert test.expected == actual : "minimumCost(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int result = 0;
        for (int i = 0; i < cost.length; i++) {
            if (i % 3 < 2) {
                result += cost[cost.length - 1 - i];
            }
        }
        return result;
    }

}