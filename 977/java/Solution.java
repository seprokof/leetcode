import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { -4, -1, 0, 3, 10 }, new int[] { 0, 1, 9, 16, 100 }),
                new TestCase(new int[] { -7, -3, 2, 3, 11 }, new int[] { 4, 9, 9, 49, 121 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.sortedSquares(test.in);
            assert Arrays.equals(test.expected, actual) : "sortedSquares(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        while (i >= 0) {
            int absLeft = Math.abs(nums[left]);
            int absRight = Math.abs(nums[right]);
            if (absLeft <= absRight) {
                result[i] = absRight * absRight;
                right--;
            } else {
                result[i] = absLeft * absLeft;
                left++;
            }
            i--;
        }
        return result;
    }

}