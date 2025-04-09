import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 2, 5, 4, 5 }, 2, 2),
                new TestCase(new int[] { 2, 1, 2 }, 2, -1),
                new TestCase(new int[] { 9, 7, 5, 3 }, 1, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in1, test.in2);
            assert test.expected == actual : "minOperations(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minOperations(int[] nums, int k) {
        boolean[] contains = new boolean[101];
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (!contains[num]) {
                contains[num] = true;
                count++;
            }
        }
        return count - (contains[k] ? 1 : 0);
    }

}