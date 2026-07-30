class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abcde", 5),
                new TestCase("xycdefghij", 12)               
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumPushes(test.in);
            assert test.expected == actual : "minimumPushes('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minimumPushes(String word) {
        int q = word.length() / 8;
        int r = word.length() % 8;
        return (4 * q + r) * (q + 1);
    }

}