class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, long expected) {}

        TestCase[] tests = {
                new TestCase(10203004, 12340L),
                new TestCase(1000, 1L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.sumAndMultiply(test.in);
            assert test.expected == actual : "sumAndMultiply(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        for (int i = 1; n > 0; n /= 10) {
            int digit = n % 10;
            if (digit == 0) {
                continue;
            }
            x += i * digit;
            sum += digit;
            i *= 10;
        }
        return 1L * x * sum;
    }

}