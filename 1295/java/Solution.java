import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 12, 345, 2, 6, 7896 }, 2),
                new TestCase(new int[] { 555, 901, 482, 1771 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findNumbers(test.in);
            assert test.expected == actual : "findNumbers(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int countDigits = 0;
            while (num / 10 > 0) {
                countDigits++;
                num /= 10;
            }
            if (++countDigits % 2 == 0) {
                result++;
            }
        }
        return result;
    }

}