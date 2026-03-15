import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 3, 10, 9, 8 }, List.of(10, 9)),
                new TestCase(new int[] { 4, 4, 7, 6, 7 }, List.of(7, 7, 6))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.minSubsequence(Arrays.copyOf(test.in, test.in.length));
            assert Objects.equals(test.expected, actual) : "minSubsequence(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int totalSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            totalSum += nums[i];
        }
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            sum += nums[i];
            if (sum > totalSum - sum) {
                break;
            }
        }
        return result;
    }

}