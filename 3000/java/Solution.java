import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 9, 3 }, { 8, 6 } }, 48),
                new TestCase(new int[][] { { 3, 4 }, { 3, 4 } }, 12)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.areaOfMaxDiagonal(test.in);
            assert test.expected == actual : "areaOfMaxDiagonal(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxSqDiagonal = 0;
        int maxArea = 0;
        for (int[] dimension : dimensions) {
            int diagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if (diagonal > maxSqDiagonal) {
                maxSqDiagonal = diagonal;
                maxArea = dimension[0] * dimension[1];
            } else if (diagonal == maxSqDiagonal) {
                maxArea = Math.max(maxArea, dimension[0] * dimension[1]);
            }
        }
        return maxArea;
    }

}