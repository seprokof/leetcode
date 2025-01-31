class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("ABAB", 2, 4),
                new TestCase("AABABBA", 1, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.characterReplacement(test.in1, test.in2);
            assert test.expected == actual : "characterReplacement('%s', %s) == %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public int characterReplacement(String s, int k) {
        if (s.length() <= k || s.length() == 1) {
            return s.length();
        }
        int[] lettersFrequency = new int[26];
        int maxLetterFrequency = 0;
        int startIdx = 0;
        int maxLen = 0;
        for (int endIdx = 0; endIdx < s.length(); endIdx++) {
            lettersFrequency[s.charAt(endIdx) - 'A']++;
            maxLetterFrequency = Math.max(maxLetterFrequency, lettersFrequency[s.charAt(endIdx) - 'A']);
            if (endIdx - startIdx + 1 > maxLetterFrequency + k) {
                lettersFrequency[s.charAt(startIdx++) - 'A']--;
            } else {
                maxLen = Math.max(maxLen, endIdx - startIdx + 1);
            }
        }
        return maxLen;
    }

}