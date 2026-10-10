import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "1", "4", "W", "6", "WD" }, new int[] { 12, 1 }),
                new TestCase(new String[] { "WD", "NB", "0", "4", "4" }, new int[] { 10, 0 }),
                new TestCase(new String[] { "W", "W", "W", "W", "W", "W", "W", "W","W", "W", "W" }, new int[] { 0, 10 })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.scoreValidator(test.in);
            assert Arrays.equals(test.expected, actual) : "scoreValidator(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] scoreValidator(String[] events) {
        int[] result = new int[2];
        for (int i = 0; i < events.length && result[1] < 10; i++) {
            String s = events[i];
            if ("W".equals(s)) {
                result[1]++;
            } else if ("WD".equals(s) || "NB".equals(s)) {
                result[0]++;
            } else {
                result[0] += Integer.valueOf(s);
            }
        }
        return result;
    }

}