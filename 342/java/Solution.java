class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase(16, true),
                new TestCase(5, false),
                new TestCase(1, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isPowerOfFour(test.in);
            assert test.expected == actual : "isPowerOfFour(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 != 0) {
            return false;
        }
        return ((int) sqrt & ((int) sqrt - 1)) == 0;
    }

}