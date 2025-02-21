class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}
        
        TestCase[] tests = {
                new TestCase("abccccdd", 7),
                new TestCase("a", 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestPalindrome(test.in);
            assert test.expected == actual : "longestPalindrome('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int longestPalindrome(String s) {
        int[] letterFrequency = new int[52];
        int len = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - (ch > 90 ? 'a' - 26 : 'A');
            letterFrequency[idx]++;
            if (letterFrequency[idx] % 2 == 0) {
                len += 2;
            }
        }
        return len + (len < s.length() ? 1 : 0);
    }

}