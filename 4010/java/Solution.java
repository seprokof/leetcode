import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3, 5 }, 15L),
                new TestCase(new int[] { 4, 6, 8 }, 12L),
                new TestCase(new int[] { 3, 3 }, 1L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maxPairStrength(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "maxPairStrength(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public long maxPairStrength(int[] nums) {
        Arrays.sort(nums);
        long result = 0L;
        for (int i = nums.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                long product = 1L * nums[i] * nums[j];
                if (product < result) {
                    break;
                }
                int gcd = gcd(nums[i], nums[j]);
                result = Math.max(result, product / gcd / gcd);
            }
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}