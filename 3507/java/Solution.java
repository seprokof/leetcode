import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 2, 3, 1 }, 2),
                new TestCase(new int[] { 1, 2, 2 }, 0)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumPairRemoval(test.in);
            assert test.expected == actual : "minimumPairRemoval(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumPairRemoval(int[] nums) {
        boolean isNonDecreasing;
        int len = nums.length;
        int result = 0;
        do {
            isNonDecreasing = true;
            int minSum = Integer.MAX_VALUE;
            int pos = 0;
            for (int i = 1; i < len; i++) {
                if (nums[i] < nums[i - 1]) {
                    isNonDecreasing = false;
                }
                int sum = nums[i - 1] + nums[i];
                if (sum < minSum) {
                    minSum = sum;
                    pos = i;
                }
            }
            if (!isNonDecreasing) {
                nums[pos - 1] = minSum;
                for (int j = pos; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
                result++;
            }
        } while (!isNonDecreasing);
        return result;
    }

}