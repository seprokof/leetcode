class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 12),
                new TestCase(5000, 30228214)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numOfWays(test.in);
            assert test.expected == actual : "numOfWays(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    private static final long MODULO = 1_000_000_007L;

    public int numOfWays(int n) {
        long same = 6L; // the first and last tiles are of the same color
        long different = 6L; // the first and last tiles are of the different colors
        for (int i = 1; i <= n; i++) {
            long updSame = (same * 3 + different * 2) % MODULO;
            long updDifferent = (same * 2 + different * 2) % MODULO;
            same = updSame;
            different = updDifferent;
        }
        return (int) ((same + different) % MODULO);
    }

}