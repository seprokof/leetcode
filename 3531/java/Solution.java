import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(3, new int[][] { { 1, 2 }, { 2, 2 }, { 3, 2 }, { 2, 1 }, { 2, 3 } }, 1),
                new TestCase(3, new int[][] { { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } }, 0),
                new TestCase(5, new int[][] { { 1, 3 }, { 3, 2 }, { 3, 3 }, { 3, 5 }, { 5, 3 } }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countCoveredBuildings(test.in1, test.in2);
            assert test.expected == actual : "countCoveredBuildings(%s, %s) = %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minX = new int[n + 1];
        int[] maxX = new int[n + 1];
        int[] minY = new int[n + 1];
        int[] maxY = new int[n + 1];
        Arrays.fill(minX, Integer.MAX_VALUE);
        Arrays.fill(minY, Integer.MAX_VALUE);
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);
            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
        }
        int result = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (minY[x] < y && maxY[x] > y && minX[y] < x && maxX[y] > x) {
                result++;
            }
        }
        return result;
    }

}