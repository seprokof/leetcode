import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, -1, 3 }, new int[][] { }, 25),
                new TestCase(new int[] { 4, -1, 4, -2, 4 }, new int[][] { { 2, 4 } }, 65),
                new TestCase(new int[] { 6, -1, -1, 6 }, new int[][] { { 0, 0 } }, 36)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.robotSim(test.in1, test.in2);
            assert test.expected == actual : "robotSim(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Obstacle> obstaclesSet = new HashSet<>(obstacles.length);
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(new Obstacle(obstacle[0], obstacle[1]));
        }
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int currentDirection = 0;
        int x = 0;
        int y = 0;
        int max = 0;
        for (int command : commands) {
            if (command == -2) {
                currentDirection = (currentDirection + 3) % 4;
            } else if (command == -1) {
                currentDirection = (currentDirection + 1) % 4;
            } else {
                int[] direction = directions[currentDirection];
                for (int i = 0; i < command; i++) {
                    int nX = x + direction[0];
                    int nY = y + direction[1];
                    if (obstaclesSet.contains(new Obstacle(nX, nY))) {
                        break;
                    }
                    x = nX;
                    y = nY;
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    private record Obstacle(int x, int y) { }

}