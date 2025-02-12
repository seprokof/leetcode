class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase(27, true),
                new TestCase(0, false),
                new TestCase(-1, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isPowerOfThree(test.in);
            assert test.expected == actual : "isPowerOfThree(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isPowerOfThree(int n) {
        // return n > 0 && Math.pow(3, Math.floor(Math.log(Integer.MAX_VALUE) / Math.log(3))) % n == 0;

        if (n <= 1) {
            return n == 1;
        }
        return n % 3 == 0 && isPowerOfThree(n / 3);

    }

}