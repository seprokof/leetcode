import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1, 1, 1 }, 10, 1L),
                new TestCase(new int[] { 3, 1, 4, 3, 2, 2, 4 }, 2, 4L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countGood(test.in1, test.in2);
            assert test.expected == actual : "countGood(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public long countGood(int[] nums, int k) {
        long result = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        int left = 0;
        long pairs = 0;
        for (int right = 0; right < nums.length; right++) {
            pairs += frequency.getOrDefault(nums[right], 0);
            frequency.merge(nums[right], 1, Integer::sum);
            while (k <= pairs) {
                result += nums.length - right;
                pairs -= frequency.compute(nums[left], (key, v) -> --v);
                left++;
            }
        }
        return result;
    }

}