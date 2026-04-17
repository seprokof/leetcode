import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 12, 21, 45, 33, 54 }, 1),
                new TestCase(new int[] { 120, 21 }, 1),
                new TestCase(new int[] { 21, 120 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMirrorPairDistance(test.in);
            assert test.expected == actual : "minMirrorPairDistance(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> prev = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (prev.containsKey(num)) {
                min = Math.min(min, i - prev.get(num));
            }
            int reversed = 0;
            for (; num != 0; num /= 10) {
                reversed = reversed * 10 + num % 10;
            }
            prev.put(reversed, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}