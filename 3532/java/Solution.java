import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[] in2, int in3, int[][] in4, boolean[] expected) {}

        TestCase[] tests = {
                new TestCase(2, new int[] { 1, 3 }, 1, new int[][] { { 0, 0 }, { 0, 1 } }, new boolean[] { true, false }),
                new TestCase(4, new int[] { 2, 5, 6, 8 }, 2, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 } }, new boolean[] { false, false, true, true })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean[] actual = s.pathExistenceQueries(test.in1, test.in2, test.in3, test.in4);
            assert Arrays.equals(test.expected, actual) : "pathExistenceQueries(%s, %s, %s, %s) == %s, want %s"
                    .formatted(test.in1, Arrays.toString(test.in2), test.in3, Arrays.deepToString(test.in4),
                            Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        component[0] = 0;
        for (int i = 1; i < n; i++) {
            component[i] = component[i - 1] + (nums[i] - nums[i - 1] > maxDiff ? 1 : 0);
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = component[query[0]] == component[query[1]];
        }
        return answer;
    }

}