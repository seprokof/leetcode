import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 4, 5, 1, 2 }, true),
                new TestCase(new int[] { 2, 1, 3, 4 }, false),
                new TestCase(new int[] { 1, 2, 3 }, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.check(test.in);
            assert test.expected == actual : "check(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean check(int[] nums) {
        int anomaly = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                anomaly++;
            }
        }
        if (nums[0] < nums[nums.length - 1]) {
            anomaly++;
        }
        return anomaly <= 1;
    }

}