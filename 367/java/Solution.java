class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase(16, true),
                new TestCase(14, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isPerfectSquare(test.in);
            assert test.expected == actual : "isPerfectSquare(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

}