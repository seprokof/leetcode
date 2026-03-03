import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } }, 3),
                new TestCase(new int[][] { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 1, 1, 0 } }, -1),
                new TestCase(new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minSwaps(test.in);
            assert test.expected == actual : "minSwaps(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> zeros = new ArrayList<>(n);
        for (int row = 0; row < n; row++) {
            int count = 0;
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] == 1) {
                    break;
                }
                count++;
            }
            zeros.add(count);
        }
        int swaps = 0;
        for (int requiredZeros = n - 1; requiredZeros > 0; requiredZeros--) {
            boolean found = false;
            for (int i = 0; i < zeros.size(); i++) {
                if (zeros.get(i) >= requiredZeros) {
                    found = true;
                    zeros.remove(i);
                    swaps += i;
                    break;
                }
            }
            if (!found) {
                return -1;
            }
        }
        return swaps;
    }

}