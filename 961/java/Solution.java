import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 3 }, 3),
                new TestCase(new int[] { 2, 1, 2, 5, 3, 2 }, 2),
                new TestCase(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.repeatedNTimes(test.in);
            assert test.expected == actual : "repeatedNTimes(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int repeatedNTimes(int[] nums) {
        Set<Integer> unique = new HashSet<>(nums.length / 2 + 1);
        for (int num : nums) {
            if (!unique.add(num)) {
                return num;
            }
        }
        return -1;
    }

}