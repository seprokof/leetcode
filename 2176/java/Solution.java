import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 1, 2, 2, 2, 1, 3 }, 2, 4),
                new TestCase(new int[] { 1, 2, 3, 4 }, 1, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countPairs(test.in1, test.in2);
            assert test.expected == actual : "countPairs(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int countPairs(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

}