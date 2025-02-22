import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 0, 1, 1, 1 }, 3),
                new TestCase(new int[] { 1, 0, 1, 1, 0, 1 }, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findMaxConsecutiveOnes(test.in);
            assert test.expected == actual : "findMaxConsecutiveOnes(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 0;
            }
        }
        return Math.max(max, current);
    }

}