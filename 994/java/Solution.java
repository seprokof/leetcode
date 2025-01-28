import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }, 4),
                new TestCase(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }, -1),
                new TestCase(new int[][] { { 0, 2 } }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.orangesRotting(test.in);
            assert test.expected == actual : "orangesRotting(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int goodOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    goodOranges++;
                }
            }
        }
        int minCount = 0;
        while (!queue.isEmpty() && goodOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                for (int[] direction : directions) {
                    int x = orange[0] + direction[0];
                    int y = orange[1] + direction[1];
                    if (x > -1 && x < grid.length && y > -1 && y < grid[0].length && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            queue.offer(new int[] { x, y });
                            visited[x][y] = true;
                            goodOranges--;
                        } else if (grid[x][y] == 0) {
                            visited[x][y] = true;
                        }
                    }
                }
            }
            minCount++;
        }
        return goodOranges == 0 ? minCount : -1;
    }

}