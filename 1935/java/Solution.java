class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase("hello world", "ad", 1),
                new TestCase("leet code", "lt", 1),
                new TestCase("leet code", "e", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.canBeTypedWords(test.in1, test.in2);
            assert test.expected == actual : "canBeTypedWords('%s', '%s') = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        int result = 0;
        boolean skip = false;
        for (char letter : text.toCharArray()) {
            if (letter == ' ') {
                if (!skip) {
                    result++;
                }
                skip = false;
            } else if (!skip && brokenLetters.indexOf(letter) > -1) {
                skip = true;
            }
        }
        if (!skip) {
            result++;
        }
        return result;
    }

}