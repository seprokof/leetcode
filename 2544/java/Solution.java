class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(521, 4),
                new TestCase(111, 1),
                new TestCase(886996, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.alternateDigitSum(test.in);
            assert test.expected == actual : "alternateDigitSum(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int alternateDigitSum(int n) {
        int sign = 1;
        int sum = 0;
        int count = 0;
        while (n > 0) {
            sum = sum + n % 10 * sign;
            sign *= -1;
            n /= 10;
            count++;
        }
        return count % 2 == 0 ? -sum : sum;
    }

}