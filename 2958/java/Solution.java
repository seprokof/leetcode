import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 1, 2, 3, 1, 2 }, 2, 6),
                new TestCase(new int[] { 1, 2, 1, 2, 1, 2, 1, 2 }, 1, 2),
                new TestCase(new int[] { 5, 5, 5, 5, 5, 5, 5 }, 4, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxSubarrayLength(test.in1, test.in2);
            assert test.expected == actual : "maxSubarrayLength(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int i = 0;
        int j = 0;
        int result = 0;
        while (j < nums.length) {
            if (frequency.merge(nums[j], 1, Integer::sum) > k) {
                result = Math.max(result, j - i);
                while (i < nums.length) {
                    frequency.put(nums[i], frequency.get(nums[i]) - 1);
                    if (nums[i++] == nums[j]) {
                        break;
                    }
                }
            }
            j++;
        }
        return Math.max(result, j - i);
    }

}