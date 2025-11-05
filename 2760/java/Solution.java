import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 2, 5, 4 }, 5, 3),
                new TestCase(new int[] { 1, 2 }, 2, 1),
                new TestCase(new int[] { 2, 3, 4, 5 }, 4, 3),
                
                new TestCase(new int[] { 4, 10, 3 }, 10, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestAlternatingSubarray(test.in1, test.in2);
            assert test.expected == actual : "longestAlternatingSubarray(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int result = 0;
        for (int left = 0; left < nums.length;) {
            if (nums[left] % 2 != 0 || nums[left] > threshold) {
                left++;
                continue;
            }
            int right = left + 1;
            for (; right < nums.length && nums[right] <= threshold
                    && ((right % 2 == left % 2 && nums[left] % 2 == nums[right] % 2)
                            || (right % 2 != left % 2 && nums[left] % 2 != nums[right] % 2)); right++) {
            }
            result = Math.max(result, right - left);
            left = right;
        }
        return result;
    }

}