class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(4, 4),
                new TestCase(5, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.gcdOfOddEvenSums(test.in);
            assert test.expected == actual : "gcdOfOddEvenSums(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, n * (n + 1));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}