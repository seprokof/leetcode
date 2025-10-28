import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 2, 0, 3 }, 2),
                new TestCase(new int[] { 2, 3, 4, 0, 4, 1, 0 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countValidSelections(test.in);
            assert test.expected == actual : "countValidSelections(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int countValidSelections(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        int rightSum = sum;
        int result = 0;
        for (int num : nums) {
            if (num == 0) {
                if (leftSum - rightSum >= 0 && leftSum - rightSum <= 1) {
                    result++;
                }
                if (rightSum - leftSum >= 0 && rightSum - leftSum <= 1) {
                    result++;
                }
            } else {
                leftSum += num;
                rightSum -= num;
            }
        }
        return result;
    }

}