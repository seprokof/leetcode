import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int in3, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 1, 7, 4, 4, 5 }, 3, 6, 6L),
                new TestCase(new int[] { 1, 7, 9, 2, 5 }, 11, 11, 1L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countFairPairs(test.in1, test.in2, test.in3);
            assert test.expected == actual : "countFairPairs(%s, %s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairsLowerThan(nums, upper) - countPairsLowerThan(nums, lower - 1);
    }

    private static long countPairsLowerThan(int[] nums, int bound) {
        long result = 0L;
        int right = nums.length - 1;
        for (int left = 0; left < right; left++) {
            while (left < right && nums[left] + nums[right] > bound) {
                right--;
            }
            result += right - left;
        }
        return result;
    }

}