class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(5, 2),
                new TestCase(8, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.arrangeCoins(test.in);
            assert test.expected == actual : "arrangeCoins(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int arrangeCoins(int n) {
        // https://en.wikipedia.org/wiki/Triangular_number#Triangular_roots_and_tests_for_triangular_numbers
        return (int) (Math.sqrt(8d * n + 1) - 1) / 2;
    }

}