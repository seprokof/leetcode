import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 4, 2, 5, 3 }, 58),
                new TestCase(new int[] { 1, 2 }, 3),
                new TestCase(new int[] { 10, 11, 12 }, 66)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumOddLengthSubarrays(test.in);
            assert test.expected == actual : "sumOddLengthSubarrays(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        for (int left = 0; left < arr.length; left++) {
            int sum = 0;
            for (int right = left; right < arr.length; right++) {
                sum += arr[right];
                if ((right - left + 1) % 2 == 1) {
                    result += sum;
                }
            }
        }
        return result;
    }

}