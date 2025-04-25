import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in1, int in2, int in3, long expected) {}

        TestCase[] tests = {
                new TestCase(List.of(3, 2, 4), 2, 1, 3L),
                new TestCase(List.of(3, 1, 9, 6), 3, 0, 2L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countInterestingSubarrays(test.in1, test.in2, test.in3);
            assert test.expected == actual : "countInterestingSubarrays(%s, %s, %s) == %s, want %s".formatted(test.in1,
                    test.in2, test.in3, actual, test.expected);
        }
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long result = 0L;
        for (int num : nums) {
            if (num % modulo == k) {
                cnt++;
            }
            int reminder = cnt % modulo;
            int target = (reminder - k + modulo) % modulo;
            result += map.getOrDefault(target, 0);
            map.merge(reminder, 1, Integer::sum);
        }
        return result;
    }

}