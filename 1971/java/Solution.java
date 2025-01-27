import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int in3, int in4, boolean expected) {}

        TestCase[] tests = {
                new TestCase(3, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 0 } }, 0, 2, true),
                new TestCase(6, new int[][] { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } }, 0, 5, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.validPath(test.in1, test.in2, test.in3, test.in4);
            assert test.expected == actual : "validPath(%s, %s, %s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), test.in3, test.in4, actual, test.expected);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) {
            return source == destination;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], (ignore) -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], (ignore) -> new HashSet<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (vertex == destination) {
                return true;
            }
            for (Integer adjV : graph.get(vertex)) {
                if (!visited[adjV]) {
                    visited[adjV] = true;
                    queue.add(adjV);
                }
            }
        }
        return false;
    }

}