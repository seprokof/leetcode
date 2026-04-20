import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1, 6, 1, 1, 1 }, 3),
                new TestCase(new int[] { 1, 8, 3, 8, 3 }, 4),
                new TestCase(new int[] { 0, 1 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDistance(test.in);
            assert test.expected == actual : "maxDistance(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int maxDistance(int[] colors) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != colors[colors.length - 1] || colors[colors.length - 1 - i] != colors[0]) {
                return colors.length - 1 - i;
            }
        }
        return -1;
    }

}