import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 2, 3, 3, 5, 7 }, 2),
                new TestCase(new int[] { 4, 5, 6, 4, 4 }, 2),
                new TestCase(new int[] { 6, 7, 8, 9 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumOperations(test.in);
            assert test.expected == actual : "minimumOperations(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            if (!set.add(nums[i])) {
                break;
            }
        }
        return Math.ceilDiv(i + 1, 3);
    }

}