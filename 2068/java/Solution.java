class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("aaaa", "bccb", false),
                new TestCase("abcdeef", "abaaacc", true),
                new TestCase("cccddabba", "babababab", true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkAlmostEquivalent(test.in1, test.in2);
            assert test.expected == actual : "checkAlmostEquivalent('%s', '%s') = %s, want %s".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] frequency = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            frequency[word1.charAt(i) - 'a']++;
            frequency[word2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(frequency[i]) > 3) {
                return false;
            }
        }
        return true;
    }

}