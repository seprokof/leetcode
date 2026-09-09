class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(long in, long expected) {}

        TestCase[] tests = {
                new TestCase(1002L, 3L),
                new TestCase(998L, 0L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countCommas(test.in);
            assert test.expected == actual : "countCommas(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public long countCommas(long n) {
        long result = 0L;
        for (long power = 1000L; power <= n; power *= 1000L) {
            result += n - power + 1;
        }
        return result;
    }

}