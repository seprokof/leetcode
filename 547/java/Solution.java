import java.util.Arrays;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }, 2),
                new TestCase(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }, 3),
                new TestCase(new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findCircleNum(test.in);
            assert test.expected == actual : "findCircleNum(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Stack<Integer> stack = new Stack<>();
        int numProvinces = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            stack.push(i);
            while (!stack.isEmpty()) {
                Integer vertex = stack.pop();
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[vertex][j] == 1) {
                            stack.push(j);
                        }
                    }
                }
            }
            numProvinces++;
        }
        return numProvinces;
    }

}