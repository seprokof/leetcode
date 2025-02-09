import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 1, 3, 3 }, 5L),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 0L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countBadPairs(test.in);
            assert test.expected == actual : "countBadPairs(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public long countBadPairs(int[] nums) {
        Long totalPairs = 1L * nums.length * (nums.length - 1) / 2;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i] - i;
            Long oldValue = map.getOrDefault(key, 0L);
            totalPairs -= oldValue;
            map.put(key, oldValue + 1);
        }
        return totalPairs;
    }

}