import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 6 }, { 2, 3 } }, 5),
                new TestCase(new int[][] { { 100, 100 }, { 100, 100 }, { 100, 100 } }, 200)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.earliestTime(test.in);
            assert test.expected == actual : "earliestTime(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            min = Math.min(min, task[0] + task[1]);
        }
        return min;
    }

}