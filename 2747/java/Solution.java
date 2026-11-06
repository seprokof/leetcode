import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int in3, int[] in4, int[] expected) {}

        TestCase[] tests = {
                new TestCase(3, new int[][] { { 1, 3 }, { 2, 6 }, { 1, 5 } }, 5, new int[] { 10, 11 }, new int[] { 1, 2 }),
                new TestCase(3, new int[][] { { 2, 4 }, { 2, 1 }, { 1, 2 }, { 3, 1 } }, 2, new int[] { 3, 4 }, new int[] { 0, 1 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.countServers(test.in1, test.in2, test.in3, test.in4);
            assert Arrays.equals(test.expected, actual) : "countServers(%s, %s, %s, %s) == %s, want %s".formatted(
                    test.in1, Arrays.deepToString(test.in2), test.in3, Arrays.toString(test.in4),
                    Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (l, r) -> l[1] - r[1]);
        Integer[] sortedQueries = new Integer[queries.length];
        Arrays.setAll(sortedQueries, i -> i);
        Arrays.sort(sortedQueries, (l, r) -> queries[l] - queries[r]);
        int left = 0;
        int right = 0;
        int active = 0;
        int[] count = new int[n + 1];
        int[] result = new int[queries.length];
        for (int q : sortedQueries) {
            while (right < logs.length && logs[right][1] <= queries[q]) {
                if (count[logs[right][0]]++ == 0) {
                    active++;
                }
                right++;
            }
            while (left < right && logs[left][1] < queries[q] - x) {
                if (--count[logs[left][0]] == 0) {
                    active--;
                }
                left++;
            }
            result[q] = n - active;
        }
        return result;
    }

}