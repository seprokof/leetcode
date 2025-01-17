import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[][] in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new char[][] { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } }, new int[] { 1, 2 }, 1),
                new TestCase(new char[][] { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } }, new int[] { 1, 0 }, 2),
                new TestCase(new char[][] { { '.', '+' } }, new int[] { 0, 0 }, -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.nearestExit(test.in1, test.in2);
            assert test.expected == actual : "nearestExit(%s, %s) == %s, want %s".formatted(printMaze(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { entrance[0], entrance[1], 0 });
        maze[entrance[0]][entrance[1]] = '+';
        int[][] directions = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] direction : directions) {
                int x = current[0] + direction[0];
                int y = current[1] + direction[1];

                if (x >= maze.length || y >= maze[0].length || x < 0 || y < 0) {
                    continue;
                }
                if (maze[x][y] == '+') {
                    continue;
                }
                if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) {
                    return current[2] + 1;
                }
                maze[x][y] = '+';
                queue.offer(new int[] { x, y, current[2] + 1 });
            }
        }
        return -1;
    }

    private static String printMaze(char[][] maze) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (char[] row : maze) {
            sb.append(" ").append(Arrays.toString(row));
        }
        sb.append(" ]");
        return sb.toString();
    }

}