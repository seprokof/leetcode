import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2, 1, 5, 4 }, 2, 12),
                new TestCase(new int[] { 2, 1 }, 1, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumOfGoodNumbers(test.in1, test.in2);
            assert test.expected == actual : "sumOfGoodNumbers(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - k;
            int right = i + k;
            int current = nums[i];
            if ((left < 0 || nums[left] < nums[i]) && (right >= nums.length || nums[right] < nums[i])) {
                sum += current;
            }
        }
        return sum;
    }

}