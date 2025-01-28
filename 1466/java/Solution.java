import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(6, new int[][] { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } }, 3),
                new TestCase(5, new int[][] { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } }, 2),
                new TestCase(3, new int[][] { { 1, 0 }, { 2, 0 }}, 0),
                new TestCase(3, new int[][] { { 1, 2 }, { 2, 0 }}, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minReorder(test.in1, test.in2);
            assert test.expected == actual : "minReorder(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        for (int i = 0; i < connections.length; i++) {
            graph.computeIfAbsent(connections[i][0], ignore -> new HashSet<>()).add(-connections[i][1]);
            graph.computeIfAbsent(connections[i][1], ignore -> new HashSet<>()).add(connections[i][0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer city = stack.pop();
            if (!visited[Math.abs(city)]) {
                if (city < 0) {
                    count++;
                    city *= -1;
                }
                visited[city] = true;
                for (Integer c : graph.get(city)) {
                    stack.push(c);
                }
            }
        }
        return count;
    }

}