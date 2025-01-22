import java.util.Arrays;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, Set<Integer> expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 1 }, Set.of(2)),
                new TestCase(new int[] { 1, 2, 1, 3, 5, 6, 4 }, Set.of(1, 5))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findPeakElement(test.in);
            assert test.expected.contains(actual) : "findPeakElement(%s) == %s, want any of %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}