class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(long in, int expected) {}

        TestCase[] tests = {
                new TestCase(1L, 5),
                new TestCase(4L, 400),
                new TestCase(50L, 564908303)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countGoodNumbers(test.in);
            assert test.expected == actual : "countGoodNumbers(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    private static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long countEven = (n + 1) / 2;
        long countOdd = n / 2;
        return (int) (binaryPow(5, countEven) * binaryPow(4, countOdd) % MOD);
    }

    private static long binaryPow(long base, long power) {
        long result = 1;
        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            power /= 2;
        }
        return result;
    }

}