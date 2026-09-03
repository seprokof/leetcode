import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 4, 7 }, true),
                new TestCase(new int[] { 2, 3 }, false),
                new TestCase(new int[] { 4, 6 }, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.uniformArray(test.in);
            assert test.expected == actual : "uniformArray(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            min = Math.min(min, num);
        }
        if (min % 2 == 1) {
            return true;
        }
        for (int num : nums1) {
            if (num % 2 == 1) {
                return false;
            }
        }
        return true;
    }

}