class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("0110111", 9),
                new TestCase("101", 2),
                new TestCase("111111", 21)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numSub(test.in);
            assert test.expected == actual : "numSub('%s') = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int numSub(String s) {
        long len = 0;
        long result = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                result += len * (len + 1) / 2;
                len = 0;
            } else {
                len++;
            }
        }
        result += len * (len + 1) / 2;
        return (int) (result % MODULO);
    }

}