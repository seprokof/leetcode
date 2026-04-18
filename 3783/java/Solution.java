class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(25, 27),
                new TestCase(10, 9),
                new TestCase(7, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.mirrorDistance(test.in);
            assert test.expected == actual : "mirrorDistance(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int mirrorDistance(int n) {
        int reversed = 0;
        for (int i = n; i != 0; i /= 10) {
            reversed = reversed * 10 + i % 10;
        }
        return Math.abs(n - reversed);
    }

}