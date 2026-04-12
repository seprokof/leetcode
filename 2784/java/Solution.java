import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 3 }, false),
                new TestCase(new int[] { 1, 3, 3, 2 }, true),
                new TestCase(new int[] { 1, 1 }, true),
                new TestCase(new int[] { 3, 4, 4, 1, 2, 1 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isGood(test.in);
            assert test.expected == actual : "isGood(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean isGood(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        if (nums.length - 1 != n) {
            return false;
        }
        int[] frequency = new int[n + 1];
        for (int num : nums) {
            frequency[num]++;
        }
        for (int i = 1; i < n; i++) {
            if (frequency[i] != 1) {
                return false;
            }
        }
        return frequency[n] == 2;
    }

}