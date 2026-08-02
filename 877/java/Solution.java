import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 3, 4, 5 }, true),
                new TestCase(new int[] { 3, 7, 2, 3 }, true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.stoneGame(test.in);
            assert test.expected == actual : "stoneGame(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean stoneGame(int[] piles) {
        return true;
    }

}