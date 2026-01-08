import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1 }, 0),
                new TestCase(new int[] { 0, 1, 0, 0, 1 }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfAlternatingGroups(test.in);
            assert test.expected == actual : "numberOfAlternatingGroups(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int numberOfAlternatingGroups(int[] colors) {
        int len = colors.length;
        int result = 0;
        for (int i = 2; i < len + 2; i++) {
            if (colors[(i - 2) % len] == colors[i % len] && colors[(i - 1) % len] != colors[i % len]) {
                result++;
            }
        }
        return result;
    }

}