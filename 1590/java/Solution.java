import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 1, 4, 2}, 6, 1),
                new TestCase(new int[] { 6, 3, 5, 2 }, 9, 2),
                new TestCase(new int[] { 1, 2, 3 }, 3, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minSubarray(test.in1, test.in2);
            assert test.expected == actual : "minSubarray(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minSubarray(int[] nums, int p) {
        long totalSum = 0L;
        for (int num : nums) {
            totalSum += num;
        }
        int totalReminder = (int) (totalSum % p);
        if (totalReminder == 0) {
            return 0;
        }
        Map<Integer, Integer> reminderToLastIndex = new HashMap<>();
        reminderToLastIndex.put(0, -1);
        long prefixSum = 0L;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int reminder = (int) (prefixSum % p);
            int targetRemainder = (reminder - totalReminder + p) % p;
            if (reminderToLastIndex.containsKey(targetRemainder)) {
                result = Math.min(result, i - reminderToLastIndex.get(targetRemainder));
            }
            reminderToLastIndex.put(reminder, i);
        }
        return result == nums.length ? -1 : result;
    }

}