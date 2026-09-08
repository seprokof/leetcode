class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1002, 3),
                new TestCase(998, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countCommas(test.in);
            assert test.expected == actual : "countCommas(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int countCommas(int n) {
        return n < 1000 ? 0 : n - 999;
    }

}