import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 84, 93, 100, 77, 90 }, 3, new int[] { 100, 93, 90 }),
                new TestCase(new int[] { 84, 93, 100, 77, 93 }, 3, new int[] { 100, 93, 84 }),
                new TestCase(new int[] { 1, 1, 1, 2, 2, 2 }, 6, new int[] { 2, 1 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.maxKDistinct(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert Arrays.equals(test.expected, actual) : "maxKDistinct(%s, %s) = %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0 && k > 0; i--) {
            if (list.isEmpty() || !Objects.equals(nums[i], list.getLast())) {
                list.add(nums[i]);
                k--;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}