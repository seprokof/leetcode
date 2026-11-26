class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(12, true),
                new TestCase(1, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canAliceWin(test.in);
            assert test.expected == actual : "canAliceWin(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public boolean canAliceWin(int n) {
        for (int i = 10; i >= 0; i--) {
            n -= i;
            if (n < 0) {
                return i % 2 != 0;
            }
        }
        throw new IllegalArgumentException();
    }

}