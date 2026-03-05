class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("0100", 1),
                new TestCase("10", 0),
                new TestCase("1111", 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in);
            assert test.expected == actual : "minOperations('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minOperations(String s) {
        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '0' && i % 2 == 0) || (s.charAt(i) == '1' && i % 2 != 0)) {
                countOne++;
            } else {
                countZero++;
            }
        }
        return Math.min(countZero, countOne);
    }

}