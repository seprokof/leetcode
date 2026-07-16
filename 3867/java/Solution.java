import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 6, 4 }, 2),
                new TestCase(new int[] { 3, 6, 2, 8 }, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.gcdSum(test.in);
            assert test.expected == actual : "gcdSum(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(max, nums[i]);
        }
        Arrays.sort(prefixGcd);
        long result = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            result += gcd(prefixGcd[nums.length - 1 - i], prefixGcd[i]);
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