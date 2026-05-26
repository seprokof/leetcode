class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("aaAbcBC", 3),
                new TestCase("abc", 0),
                new TestCase("abBCab", 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfSpecialChars(test.in);
            assert test.expected == actual : "numberOfSpecialChars('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char letter : word.toCharArray()) {
            if (letter < 'a') {
                upper[letter - 'A'] = true;
            } else {
                lower[letter - 'a'] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                result++;
            }
        }
        return result;
    }

}