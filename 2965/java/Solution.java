import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 3 }, { 2, 2 } }, new int[] { 2, 4 }),
                new TestCase(new int[][] { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } }, new int[] { 9, 5 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findMissingAndRepeatedValues(test.in);
            assert Arrays.equals(test.expected, actual) : "findMissingAndRepeatedValues(%s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long actualSum = 0;
        long actualSqrSum = 0;
        for (int[] row : grid) {
            for (int v : row) {
                actualSum += v;
                actualSqrSum += v * v;
            }
        }
        long sqrN = grid.length * grid.length;
        long expectedSum = sqrN * (sqrN + 1) / 2;
        long expectedSqrSum = sqrN * (sqrN + 1) * (2 * sqrN + 1) / 6;
        long sumDiff = expectedSum - actualSum;
        long sqrSumDiff = expectedSqrSum - actualSqrSum;
        return new int[] { (int) (sqrSumDiff / sumDiff - sumDiff) / 2, (int) (sqrSumDiff / sumDiff + sumDiff) / 2 };
    }

}