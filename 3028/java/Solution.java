import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3, -5 }, 1),
                new TestCase(new int[] { 3, 2, -3, -4 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.returnToBoundaryCount(test.in);
            assert Objects.equals(test.expected, actual) : "returnToBoundaryCount(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int returnToBoundaryCount(int[] nums) {
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            if (sum == 0) {
                result++;
            }
        }
        return result;
    }

}