import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 1, 2, 2 }, 4),
                new TestCase(new int[] { 5, 5, 5, 5 }, 10)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countCompleteSubarrays(test.in);
            assert test.expected == actual : "countCompleteSubarrays(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int distinct = set.size();
        Map<Integer, Integer> frequency = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            frequency.merge(nums[right], 1, Integer::sum);
            while (frequency.size() == distinct) {
                result += (nums.length - right);
                frequency.compute(nums[left++], (k, v) -> v > 1 ? --v : null);
            }
        }
        return result;
    }

}