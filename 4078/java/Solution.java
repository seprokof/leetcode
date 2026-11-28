class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(16, true),
                new TestCase(8, false),
                new TestCase(2, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.threeFibonacciSum(test.in);
            assert test.expected == actual : "threeFibonacciSum(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean threeFibonacciSum(int n) {
        if (n % 2 != 0) {
            return false;
        }
        int one = 0;
        int two = 1;
        int three = 1;
        int sum = 2;
        while (sum < n) {
            one = two;
            two = three;
            three = one + two;
            sum = one + two + three;
        }
        return sum == n;
    }

}