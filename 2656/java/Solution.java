import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 3, 18),
                new TestCase(new int[] { 5, 5, 5 }, 2, 11)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximizeSum(test.in1, test.in2);
            assert test.expected == actual : "maximizeSum(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += (max + i);
        }
        return result;
    }

}