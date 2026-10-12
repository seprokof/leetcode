import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 2 }, 4),
                new TestCase(new int[] { 1, 1, 1, 1, 1 }, 0),
                new TestCase(new int[] { 1, 2, 3, 4, 5 }, 15)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumOfUnique(test.in);
            assert test.expected == actual : "sumOfUnique(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int sumOfUnique(int[] nums) {
        int[] frequency = new int[101];
        for (int num : nums) {
            frequency[num]++;
        }
        int result = 0;
        for (int i = 0; i < 101; i++) {
            if (frequency[i] == 1) {
                result += i;
            }
        }
        return result;
    }

}