import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, int[][] in3, int[][] in4, int[] in5, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 1, 0 }, new int[] { 7, 5, 4, 100 }, new int[][] { {}, {}, { 1 }, {} }, new int[][] { { 1, 2 }, { 3 }, {}, {} }, new int[] { 0 }, 16),
                new TestCase(new int[] { 1, 0, 0, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 1, 1 }, new int[][] { { 1, 2, 3, 4, 5 }, {}, {}, {}, {}, {} }, new int[][] { { 1, 2, 3, 4, 5 }, {}, {}, {}, {}, {} }, new int[] { 0 }, 6)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxCandies(test.in1, test.in2, test.in3, test.in4, test.in5);
            assert test.expected == actual : "maxCandies(%s, %s, %s, %s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), Arrays.toString(test.in2), Arrays.deepToString(test.in3),
                    Arrays.deepToString(test.in4), Arrays.toString(test.in5), actual, test.expected);
        }
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            queue.offer(box);
        }
        boolean[] foundKeys = new boolean[status.length];
        boolean[] visited = new boolean[status.length];
        int result = 0;
        while (!queue.isEmpty()) {
            int currentBox = queue.poll();
            if (status[currentBox] == 0) {
                if (!foundKeys[currentBox]) {
                    if (!visited[currentBox]) {
                        visited[currentBox] = true;
                        queue.offer(currentBox);
                    }
                    continue;
                }
            }
            result += candies[currentBox];
            for (int box : containedBoxes[currentBox]) {
                queue.offer(box);
            }
            for (int key : keys[currentBox]) {
                foundKeys[key] = true;
            }
            visited[currentBox] = true;
        }
        return result;
    }

}