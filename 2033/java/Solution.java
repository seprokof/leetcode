import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 2, 4 }, { 6, 8 } }, 2, 4),
                new TestCase(new int[][] { { 1, 5 }, { 2, 3 } }, 1, 5),
                new TestCase(new int[][] { { 1, 2 }, { 3, 4 } }, 2, -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in1, test.in2);
            assert test.expected == actual : "minOperations(%s, %s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int minOperations(int[][] grid, int x) {
        int reminder = grid[0][0] % x;
        int[] arr = new int[grid.length * grid[0].length];
        int i = 0;
        for (int[] row : grid) {
            for (int v : row) {
                if (v % x != reminder) {
                    return -1;
                }
                arr[i++] = v;
            }
        }
        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        int countOperations = 0;
        for (int v : arr) {
            countOperations += Math.abs(v - median) / x;
        }
        return countOperations;
    }

}