class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 1),
                new TestCase(3, 2),
                new TestCase(4, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.fib(test.in);
            assert test.expected == actual : "fib(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[n];
    }

}