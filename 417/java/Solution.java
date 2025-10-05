import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } }, List.of(List.of(0, 4), List.of(1, 3), List.of(1, 4), List.of(2, 2), List.of(3, 0), List.of(3, 1), List.of(4, 0))),
                new TestCase(new int[][] { { 1 } }, List.of(List.of(0, 0)))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.pacificAtlantic(test.in);
            assert Objects.equals(test.expected, actual) : "pacificAtlantic(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
        boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];
        for (int row = 0; row < heights.length; row++) {
            dfs(0, row, -1, heights, visitedPacific);
            dfs(heights[0].length - 1, row, -1, heights, visitedAtlantic);
        }
        for (int col = 0; col < heights[0].length; col++) {
            dfs(col, 0, -1, heights, visitedPacific);
            dfs(col, heights.length - 1, -1, heights, visitedAtlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (visitedPacific[row][col] && visitedAtlantic[row][col]) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }

    private static void dfs(int x, int y, int height, int[][] heights, boolean[][] visited) {
        if (x < 0 || x > heights[0].length - 1 || y < 0 || y > heights.length - 1 || visited[y][x]
                || heights[y][x] < height) {
            return;
        }
        visited[y][x] = true;
        for (int[] dir : DIRECTIONS) {
            dfs(x + dir[0], y + dir[1], heights[y][x], heights, visited);
        }
    }

}