import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 10 }, false),
                new TestCase(new int[] { 1, 2, 3, 4, 5, 14 }, true),
                new TestCase(new int[] { 5, 5, 5, 25 }, true)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canAliceWin(test.in);
            assert test.expected == actual : "canAliceWin(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num > 9) {
                sum -= num;
            } else {
                sum += num;
            }
        }
        return sum != 0;
    }

}