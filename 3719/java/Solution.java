import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 5, 4, 3 }, 4),
                new TestCase(new int[] { 3, 2, 2, 5, 4 }, 5),
                new TestCase(new int[] { 1, 2, 3, 2 }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestBalanced(test.in);
            assert test.expected == actual : "longestBalanced(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int longestBalanced(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - max; i++) {
            Set<Integer> distinct = new HashSet<>();
            int even = 0;
            int odd = 0;
            for (int j = i; j < nums.length; j++) {
                if (distinct.add(nums[j])) {
                    if (nums[j] % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }
                if (even == odd) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

}