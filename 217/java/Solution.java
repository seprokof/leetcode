import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 1 }, true),
                new TestCase(new int[] { 1, 2, 3, 4 }, false),
                new TestCase(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.containsDuplicate(test.in);
            assert test.expected == actual : "containsDuplicate(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}