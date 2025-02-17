class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase("abab", true),
                new TestCase("aba", false),
                new TestCase("abcabcabcabc", true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.repeatedSubstringPattern(test.in);
            assert test.expected == actual : "repeatedSubstringPattern('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.charAt(0) == s.charAt(i)) {
                if (s.length() % i != 0) {
                    continue;
                }
                boolean isValid = true;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j % i) != s.charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    return true;
                }
            }
        }
        return false;
    }

}