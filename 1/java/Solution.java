import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
                new TestCase(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 }),
                new TestCase(new int[] { 3, 3 }, 6, new int[] { 0, 1 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.twoSum(test.in1, test.in2);
            assert Arrays.equals(test.expected, actual) : "twoSum(%s, %s) == %s, want %s".formatted(
                    Arrays.toString(test.in1), test.in2, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                return new int[] { valueToIndex.get(target - nums[i]), i };
            }
            valueToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("Invalid input");
    }

}