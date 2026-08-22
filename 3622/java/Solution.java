class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(99, true),
                new TestCase(23, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkDivisibility(test.in);
            assert test.expected == actual : "checkDivisibility(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkDivisibility(int n) {
        int nCopy = n;
        int sum = 0;
        int product = 1;
        while (nCopy > 0) {
            int digit = nCopy % 10;
            sum += digit;
            product *= digit;
            nCopy /= 10;
        }
        return n % (sum + product) == 0;
    }

}