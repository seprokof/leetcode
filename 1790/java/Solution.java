class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("bank", "kanb", true),
                new TestCase("attack", "defend", false),
                new TestCase("kelb", "kelb", true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.areAlmostEqual(test.in1, test.in2);
            assert test.expected == actual : "areAlmostEqual('%s', '%s') == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean areAlmostEqual(String s1, String s2) {
        int firstUnmatchedIdx = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstUnmatchedIdx == -1) {
                    firstUnmatchedIdx = i;
                } else if (firstUnmatchedIdx == s1.length()) {
                    return false;
                } else if (s1.charAt(i) != s2.charAt(firstUnmatchedIdx)
                        || s1.charAt(firstUnmatchedIdx) != s2.charAt(i)) {
                    return false;
                } else {
                    firstUnmatchedIdx = s1.length();
                }
            }
        }
        return firstUnmatchedIdx == -1 || firstUnmatchedIdx == s1.length();
    }

}