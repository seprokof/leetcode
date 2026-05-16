import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 5 }, 1),
                new TestCase(new int[] { 2, 2, 2, 0, 1 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findMin(test.in);
            assert test.expected == actual : "findMin(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int findMin(int[] nums) {
        int last = nums.length - 1;
        int left = 0;
        int right = last;
        while (left < last && nums[left] == nums[last]) {
            left++;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[last]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}