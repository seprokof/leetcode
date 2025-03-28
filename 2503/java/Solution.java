import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int[] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 2, 5, 7 }, { 3, 5, 1 } }, new int[] { 5, 6, 2 }, new int[] { 5, 8, 1 }),
                new TestCase(new int[][] { { 5, 2, 1 }, { 1, 1, 2 } }, new int[] { 3 }, new int[] { 0 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.maxPoints(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "maxPoints(%s, %s) == %s, want %s".formatted(
                    Arrays.deepToString(test.in1), Arrays.toString(test.in2), Arrays.toString(actual),
                    Arrays.toString(test.expected));
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int queriesLen = queries.length;
        int[][] queryToIndex = new int[queriesLen][2];
        for (int i = 0; i < queriesLen; i++) {
            queryToIndex[i][0] = queries[i];
            queryToIndex[i][1] = i;
        }
        Arrays.sort(queryToIndex, (l, r) -> l[0] - r[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((l, r) -> l[2] - r[2]);
        int gridXLen = grid[0].length;
        int gridYLen = grid.length;
        boolean[][] visited = new boolean[gridYLen][gridXLen];
        queue.offer(new int[] { 0, 0, grid[0][0] });
        visited[0][0] = true;
        int points = 0;
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int[] answer = new int[queriesLen];
        for (int[] queryWithIdx : queryToIndex) {
            while (!queue.isEmpty() && queue.peek()[2] < queryWithIdx[0]) {
                int[] current = queue.poll();
                points++;
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < gridXLen && y < gridYLen && !visited[y][x]) {
                        queue.offer(new int[] { x, y, grid[y][x] });
                        visited[y][x] = true;
                    }
                }
            }
            answer[queryWithIdx[1]] = points;
        }
        return answer;
    }

}