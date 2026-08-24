import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 1, 4, 0, 3, 5 }, 2),
                new TestCase(new int[] { 1, 100 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.distinctAverages(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "distinctAverages(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> unique = new HashSet<>();
        for (int low = 0, high = nums.length - 1; low < high; low++, high--) {
            double average = (nums[low] + nums[high]) / 2.0D;
            unique.add(average);
        }
        return unique.size();
    }

}