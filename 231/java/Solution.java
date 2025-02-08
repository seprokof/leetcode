class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(1, true),
                new TestCase(16, true),
                new TestCase(3, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isPowerOfTwo(test.in);
            assert test.expected == actual : "isPowerOfTwo(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}