import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 10, 1, 2, 7, 1, 3 }, 2, 1),
                new TestCase(new int[] { 4, 2, 1, 2 }, 1, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimizeMax(test.in1, test.in2);
            assert test.expected == actual : "minimizeMax(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) < p) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int countPairs(int[] nums, int threshold) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= threshold) {
                result++;
                i++;
            }
        }
        return result;
    }

}