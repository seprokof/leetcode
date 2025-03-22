import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(6, new int[][]{ { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } }, 3),
                new TestCase(6, new int[][]{ { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }, { 3, 5 } }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countCompleteComponents(test.in1, test.in2);
            assert test.expected == actual : "countCompleteComponents(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adjacencyMatrix = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyMatrix[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjacencyMatrix[edge[0]].add(edge[1]);
            adjacencyMatrix[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            queue.offer(i);
            visited[i] = true;
            int vertexCount = 0;
            int edgesCount = 0;
            while (!queue.isEmpty()) {
                Integer vertex = queue.poll();
                vertexCount++;
                for (int v : adjacencyMatrix[vertex]) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                    edgesCount++;
                }
            }
            if (vertexCount * (vertexCount - 1) / 2 == edgesCount / 2) {
                result++;
            }
        }
        return result;
    }

}