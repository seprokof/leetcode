import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3 }, true),
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
        return true;
    }

}