import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(4, new int[][] { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } }, new int[] { 1, 2, 2, 3 }),
                new TestCase(4, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 2 }, { 3, 4 }, { 4, 5 } }, new int[] { 1, 2, 2, 3, 4 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.queryResults(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "queryResults(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorToBallCount = new HashMap<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Integer oldValue = ballToColor.get(query[0]);
            if (oldValue != null && !oldValue.equals(query[1])) {
                Integer count = colorToBallCount.get(oldValue);
                if (count == 1) {
                    colorToBallCount.remove(oldValue);
                } else {
                    colorToBallCount.put(oldValue, --count);
                }
                insert(query[0], query[1], ballToColor, colorToBallCount);
            } else if (oldValue == null) {
                insert(query[0], query[1], ballToColor, colorToBallCount);
            }
            result[i] = colorToBallCount.size();
        }
        return result;
    }

    private static void insert(int ball, int color, Map<Integer, Integer> ballToColor,
            Map<Integer, Integer> colorToBallCount) {
        ballToColor.put(ball, color);
        colorToBallCount.put(color, colorToBallCount.getOrDefault(color, 0) + 1);
    }

}