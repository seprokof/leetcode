import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { -2, -1, -1, 1, 2, 3 }, 3),
                new TestCase(new int[] { -3, -2, -1, 0, 0, 1, 2 }, 3),
                new TestCase(new int[] { 5, 20, 66, 1314 }, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumCount(test.in);
            assert test.expected == actual : "maximumCount(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maximumCount(int[] nums) {
        if (nums[0] * nums[nums.length - 1] > 0) {
            return nums.length;
        }
        int lastNegativeIdx = bsLastNegative(nums, 0, nums.length - 1);
        int firstPositiveIdx = lastNegativeIdx + 1;
        for (; firstPositiveIdx < nums.length && nums[firstPositiveIdx] == 0; firstPositiveIdx++);
        return Math.max(lastNegativeIdx + 1, nums.length - firstPositiveIdx);
    }

    private static int bsLastNegative(int[] arr, int startIdx, int endIdx) {
        int midIdx = startIdx + (endIdx - startIdx) / 2;
        if (arr[midIdx] >= 0) {
            if (midIdx == 0 || arr[midIdx - 1] < 0) {
                return midIdx - 1;
            }
            return bsLastNegative(arr, startIdx, midIdx);
        } else if (midIdx == arr.length - 1 || arr[midIdx + 1] >= 0) {
            return midIdx;
        } else {
            return bsLastNegative(arr, midIdx, endIdx);
        }
    }

}