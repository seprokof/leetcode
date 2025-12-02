import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 0 }, { 2, 0 }, { 3, 0 }, { 2, 2 }, { 3, 2 } }, 3),
                new TestCase(new int[][] { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 2, 1 } }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countTrapezoids(test.in);
            assert test.expected == actual : "countTrapezoids(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> yCount = new HashMap<>();
        for (int[] point : points) {
            yCount.merge(point[1], 1, Integer::sum);
        }
        long totalEdgeCount = 0L;
        long result = 0L;
        for (Integer count : yCount.values()) {
            long edgesCount = (long) count * (count - 1) / 2;
            result = (result + edgesCount * totalEdgeCount) % MODULO;
            totalEdgeCount = (totalEdgeCount + edgesCount) % MODULO;
        }
        return (int) result;
    }

}