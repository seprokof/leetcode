class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("32", 3),
                new TestCase("82734", 8),
                new TestCase("27346209830709182346", 9)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minPartitions(test.in);
            assert test.expected == actual : "minPartitions('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minPartitions(String n) {
        int maxDigit = 0;
        for (char digit : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, digit - '0');
        }
        return maxDigit;
    }

}