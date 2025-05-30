import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 2, 3, -1 }, 0, 1, 2),
                new TestCase(new int[] { 1, 2, -1 }, 0, 2, 2),
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.closestMeetingNode(test.in1, test.in2, test.in3);
            assert test.expected == actual : "closestMeetingNode(%s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Integer[] node1Distances = evaluateDistances(node1, edges);
        Integer[] node2Distances = evaluateDistances(node2, edges);
        int minDistance = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < edges.length; i++) {
            if (node1Distances[i] != null && node2Distances[i] != null) {
                int max = Math.max(node1Distances[i], node2Distances[i]);
                if (max < minDistance) {
                    minDistance = max;
                    result = i;
                }
            }
        }
        return result;
    }

    private static Integer[] evaluateDistances(int node, int[] edges) {
        Integer[] distances = new Integer[edges.length];
        Integer distance = 0;
        while (node != -1 && distances[node] == null) {
            distances[node] = distance++;
            node = edges[node];
        }
        return distances;
    }

}