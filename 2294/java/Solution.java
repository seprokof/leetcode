import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 6, 1, 2, 5 }, 2, 2),
                new TestCase(new int[] { 1, 2, 3 }, 1, 2),
                new TestCase(new int[] { 2, 2, 4, 5 }, 0, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.partitionArray(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "partitionArray(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 1;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - min > k) {
                result++;
                min = nums[i];
            }
        }
        return result;
    }

}