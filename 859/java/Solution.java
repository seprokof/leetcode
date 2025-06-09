class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase("ab", "ba", true),
                new TestCase("aa", "ab", false),
                new TestCase("aa", "aa", true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.buddyStrings(test.in1, test.in2);
            assert test.expected == actual : "buddyStrings('%s', '%s') == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                if (++freq[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (i1 == -1) {
                    i1 = i;
                } else if (i2 == -1) {
                    i2 = i;
                } else {
                    return false;
                }
            }
        }
        return i2 > 0 && s.charAt(i1) == goal.charAt(i2) && s.charAt(i2) == goal.charAt(i1);
    }

}