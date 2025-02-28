class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase("abcde", "ace",  3),
                new TestCase("abc", "abc", 3),
                new TestCase("abc", "def",  0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestCommonSubsequence(test.in1, test.in2);
            assert test.expected == actual : "longestCommonSubsequence('%s', '%s') == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            int[] temp = curr;
            curr = prev;
            prev = temp;
        }
        return prev[text2.length()];
    }

}