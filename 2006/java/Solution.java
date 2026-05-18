import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 1 }, 1, 4),
                new TestCase(new int[] { 1, 3 }, 3, 0),
                new TestCase(new int[] { 3, 2, 1, 5, 4 }, 2, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countKDifference(test.in1, test.in2);
            assert test.expected == actual : "countKDifference(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int countKDifference(int[] nums, int k) {
        int[] frequency = new int[101];
        for (int num : nums) {
            frequency[num]++;
        }
        int result = 0;
        for (int i = 1; i + k < 101; i++) {
            result += frequency[i] * frequency[i + k];
        }
        return result;
    }

}