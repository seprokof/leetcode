class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, long expected) {}
        
        TestCase[] tests = {
                new TestCase(1, 1L),
                new TestCase(2, 5L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.coloredCells(test.in);
            assert test.expected == actual : "coloredCells(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public long coloredCells(int n) {
        return 1 + (long) 2 * n * (n - 1);
    }

}