import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, 5, 2),
                new TestCase(new int[] { 3, 1, 3, 4, 3 }, 6, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxOperations(test.in1, test.in2);
            assert test.expected == actual : "maxOperations(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int current = nums[left] + nums[right];
            if (current == k) {
                left++;
                right--;
                result++;
            } else if (current < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

}