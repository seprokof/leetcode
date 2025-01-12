class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("abc", "ahbgdc", true),
                new TestCase("axc", "ahbgdc", false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isSubsequence(test.in1, test.in2);
            assert test.expected == actual : "isSubsequence('%s', '%s') == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        char[] ss = s.toCharArray();
        int ssIdx = 0;
        for (char ch : t.toCharArray()) {
            if (ch == ss[ssIdx]) {
                if (ssIdx == ss.length - 1) {
                    return true;
                } else {
                    ssIdx++;
                }
            }
        }
        return false;
    }

}