class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("cat and  dog", 3),
                new TestCase("!this  1-s b8d!", 0),
                new TestCase("alice and  bob are playing stone-game10", 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countValidWords(test.in);
            assert test.expected == actual : "countValidWords('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countValidWords(String sentence) {
        boolean skip = false;
        int start = 0;
        int hyphen = -1;
        int punctuationMark = -1;
        int result = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                if (!skip && isValidWord(start, i - 1, hyphen, punctuationMark, sentence)) {
                    result++;
                }
                skip = false;
                start = i + 1;
                hyphen = -1;
                punctuationMark = -1;
            } else if (Character.isDigit(ch)) {
                skip = true;
            } else if (ch == '-') {
                if (hyphen > -1) {
                    skip = true;
                } else {
                    hyphen = i;
                }
            } else if (ch == '!' || ch == '.' || ch == ',') {
                if (punctuationMark > -1) {
                    skip = true;
                } else {
                    punctuationMark = i;
                }
            }
        }
        if (!skip && isValidWord(start, sentence.length() - 1, hyphen, punctuationMark, sentence)) {
            result++;
        }
        return result;
    }

    private static boolean isValidWord(int start, int end, int hyphen, int punctuationMark, String sentence) {
        if (end - start < 0 || (end - start == 0 && sentence.charAt(end) == ' ')) {
            return false;
        }
        if (hyphen > -1 && (hyphen == start || hyphen == end || !Character.isLetter(sentence.charAt(hyphen - 1))
                || !Character.isLetter(sentence.charAt(hyphen + 1)))) {
            return false;
        }
        if (punctuationMark > -1 && punctuationMark != end) {
            return false;
        }
        return true;
    }

}