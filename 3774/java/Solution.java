import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 2, 2, 4 }, 2, 5),
                new TestCase(new int[] { 100 }, 1, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.absDifference(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "absDifference(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int hSum = 0;
        int lSum = 0;
        for (int i = 0; i < k; i++) {
            hSum += nums[nums.length - 1 - i];
            lSum += nums[i];
        }
        return hSum - lSum;
    }

}