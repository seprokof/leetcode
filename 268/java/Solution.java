import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 3, 0, 1 }, 2),
                new TestCase(new int[] { 0, 1 }, 2),
                new TestCase(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }, 8)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.missingNumber(test.in);
            assert test.expected == actual : "missingNumber(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

}