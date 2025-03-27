import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<Integer> in, int expected) {}

        TestCase[] tests = {
                new TestCase(List.of(1, 2, 2, 2), 2),
                new TestCase(List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1), 4),
                new TestCase(List.of(3, 3, 3, 3, 7, 2, 2), -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumIndex(test.in);
            assert test.expected == actual : "minimumIndex(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> frequency = new HashMap<>(nums.size());
        Integer maxNum = nums.get(0);
        Integer maxFreq = 0;
        for (Integer n : nums) {
            Integer freq = frequency.merge(n, 1, Integer::sum);
            if (freq > maxFreq) {
                maxNum = n;
                maxFreq = freq;
            }
        }
        int prev = 0;
        int current = 0;
        for (int i = 0; i < nums.size(); i++) {
            current = prev + (nums.get(i).equals(maxNum) ? 1 : 0);
            if (current * 2 > i + 1 && (maxFreq - current) * 2 > nums.size() - i - 1) {
                return i;
            }
            prev = current;
        }
        return -1;
    }

}