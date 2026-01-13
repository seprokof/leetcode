import java.util.List;

class Solution {

    private static final String DOWN = "DOWN";
    private static final String LEFT = "LEFT";
    private static final String RIGHT = "RIGHT";
    private static final String UP = "UP";

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, List<String> in2, int expected) {}

        TestCase[] tests = {
                new TestCase(2, List.of(RIGHT, DOWN), 3),
                new TestCase(3, List.of(DOWN, RIGHT, UP), 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.finalPositionOfSnake(test.in1, test.in2);
            assert test.expected == actual : "finalPositionOfSnake(%s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for (String command : commands) {
            switch (command) {
            case DOWN -> y++;
            case LEFT -> x--;
            case RIGHT -> x++;
            case UP -> y--;
            }
        }
        return y * n + x;
    }

}