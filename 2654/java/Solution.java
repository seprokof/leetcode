import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 6, 3, 4 }, 4),
                new TestCase(new int[] { 2, 10, 6, 14 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in);
            assert test.expected == actual : "minOperations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minOperations(int[] nums) {
        int overallGcd = 0;
        int ones = 0;
        for (int num : nums) {
            overallGcd = gcd(overallGcd, num);
            if (num == 1) {
                ones++;
            }
        }
        if (overallGcd > 1) {
            return -1;
        }
        if (ones > 0) {
            return nums.length - ones;
        }
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int intervalGcd = 0;
            for (int j = i; j < nums.length; j++) {
                intervalGcd = gcd(intervalGcd, nums[j]);
                if (intervalGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + nums.length - 2;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}