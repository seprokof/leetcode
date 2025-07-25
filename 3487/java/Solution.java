import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 15),
                new TestCase(new int[] { 1, 1, 0, 1, 1 }, 1),
                new TestCase(new int[] { 1, 2, -1, -2, 1, 0, -1 }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxSum(test.in);
            assert test.expected == actual : "maxSum(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int maxSum(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (unique.add(num) && num > 0) {
                sum += num;
            }
            max = Math.max(max, num);
        }
        return sum == 0 ? max : sum;
    }

}