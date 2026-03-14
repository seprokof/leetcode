import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, true),
                new TestCase(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.hasGroupsSizeX(test.in);
            assert test.expected == actual : "hasGroupsSizeX(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] frequency = new int[10000];
        for (int card : deck) {
            frequency[card]++;
        }
        for (int i = 2; i <= deck.length; i++) {
            if (isDivisor(frequency, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDivisor(int[] values, int candidate) {
        for (int v : values) {
            if (v > 0 && v % candidate != 0) {
                return false;
            }
        }
        return true;
    }

}