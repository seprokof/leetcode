import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2, 6),
                new TestCase(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3, 10)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestOnes(test.in1, test.in2);
            assert test.expected == actual : "longestOnes(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int longestOnes(int[] nums, int k) {
        if (k == nums.length) {
            return k;
        }
        int start = 0;
        int end = 0;
        int zerosCount = 0;
        int max = 0;
        for (; end < nums.length; end++) {
            if (nums[end] == 0) {
                zerosCount++;
                if (zerosCount > k) {
                    max = Math.max(max, end - start);
                    while (zerosCount > k) {
                        if (nums[start++] == 0) {
                            zerosCount--;
                        }
                    }
                }
            }
        }
        return Math.max(max, end - start);
    }

}