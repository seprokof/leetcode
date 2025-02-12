import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 18, 43, 36, 13, 7 }, 54),
                new TestCase(new int[] { 10, 12, 19, 14},  -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumSum(test.in);
            assert test.expected == actual : "maximumSum(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int maximumSum(int[] nums) {
        int max = -1;
        int[] sumToNumber = new int[82];
        for (int num : nums) {
            int sum = 0;
            int temp = num;
            for (sum = 0; temp > 0; sum += temp % 10, temp /= 10);
            if (sumToNumber[sum] > 0) {
                max = Math.max(max, num + sumToNumber[sum]);
            }
            sumToNumber[sum] = Math.max(num, sumToNumber[sum]);
        }
        return max;
    }

}