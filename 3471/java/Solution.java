import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 9, 2, 1, 7 }, 3, 7),
                new TestCase(new int[] { 3, 9, 7, 2, 1, 7 }, 4, 3),
                new TestCase(new int[] { 0, 0 }, 1, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.largestInteger(test.in1, test.in2);
            assert test.expected == actual : "largestInteger(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int largestInteger(int[] nums, int k) {
        if (k == nums.length) {
            int result = -1;
            for (int num : nums) {
                result = Math.max(result, num);
            }
            return result;
        }
        int[] frequency = new int[51];
        for (int num : nums) {
            frequency[num]++;
        }
        if (k == 1) {
            int result = -1;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] == 1) {
                    result = Math.max(result, i);
                }
            }
            return result;
        } else {
            int f1 = frequency[nums[0]];
            int f2 = frequency[nums[nums.length - 1]];
            if (f1 == 1 && f2 == 1) {
                return Math.max(nums[0], nums[nums.length - 1]);
            } else if (f1 == 1) {
                return nums[0];
            } else if (f2 == 1) {
                return nums[nums.length - 1];
            } else {
                return -1;
            }
        }
    }

}