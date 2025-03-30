class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase("aba", "cdc", 3),
                new TestCase("aaa", "bbb", 3),
                new TestCase("aaa", "aaa", -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findLUSlength(test.in1, test.in2);
            assert test.expected == actual : "findLUSlength(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

}