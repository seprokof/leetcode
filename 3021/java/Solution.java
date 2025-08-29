class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(3, 2, 3L),
                new TestCase(1, 1, 0L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.flowerGame(test.in1, test.in2);
            assert test.expected == actual : "flowerGame(%s, %s) = %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public long flowerGame(int n, int m) {
        return 1L * n * m / 2;
    }

}