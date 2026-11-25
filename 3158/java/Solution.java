import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 1, 3 }, 1),
                new TestCase(new int[] { 1, 2, 3 }, 0),
                new TestCase(new int[] { 1, 2, 2, 1 }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.duplicateNumbersXOR(test.in);
            assert test.expected == actual : "duplicateNumbersXOR(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int duplicateNumbersXOR(int[] nums) {
        int[] frequency = new int[51];
        for (int num : nums) {
            frequency[num]++;
        }
        int result = 0;
        for (int i = 1; i < frequency.length; i++) {
            if (frequency[i] == 2) {
                result ^= i;
            }
        }
        return result;
    }

}