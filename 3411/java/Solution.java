import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 1, 2, 1, 1, 1 }, 5),
                new TestCase(new int[] { 2, 3, 4, 5, 6 }, 3),
                new TestCase(new int[] { 1, 2, 3, 1, 4, 5, 1 }, 5)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxLength(test.in);
            assert test.expected == actual : "maxLength(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int maxLength(int[] nums) {
        int result = 1;
        for (int start = 0; start < nums.length - 1; start++) {
            long product = nums[start];
            long gcd = nums[start];
            long lcm = nums[start];
            for (int end = start + 1; end < nums.length; end++) {
                product *= nums[end];
                gcd = gcd(gcd, nums[end]);
                lcm = (lcm * nums[end]) / gcd(lcm, nums[end]);
                if (product != gcd * lcm) {
                    break;
                }
                result = Math.max(result, end + 1 - start);
            }
        }
        return result;
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}