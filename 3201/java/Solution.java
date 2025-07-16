import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, 4),
                new TestCase(new int[] { 1, 2, 1, 1, 2, 1, 2 }, 6),
                new TestCase(new int[] { 1, 3 }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumLength(test.in);
            assert test.expected == actual : "maximumLength(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        int mixed = 0;
        boolean parity = nums[0] % 2 == 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            if ((num % 2 == 0) == parity) {
                mixed++;
                parity = !parity;
            }
        }
        return Math.max(Math.max(even, odd), mixed);
    }

}