class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("1001101", 4),
                new TestCase("00111", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxOperations(test.in);
            assert test.expected == actual : "maxOperations('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maxOperations(String s) {
        int ones = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                result += ones;
            }
        }
        return result;
    }

}