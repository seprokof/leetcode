import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }, 1),
                new TestCase(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numIslands(test.in);
            assert test.expected == actual : "numIslands(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int numIslands(char[][] grid) {
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                grid[i][j] = '0';
                queue.offer(new int[] { j, i });
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    for (int[] direction : directions) {
                        int x = current[0] + direction[0];
                        int y = current[1] + direction[1];
                        if (x > -1 && x < n && y > -1 && y < m && grid[y][x] == '1') {
                            grid[y][x] = '0';
                            queue.offer(new int[] { x, y });
                        }
                    }
                }
                numIslands++;
            }
        }
        return numIslands;
    }

}