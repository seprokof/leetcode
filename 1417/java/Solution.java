import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, Set<String> expected) {}

        TestCase[] tests = {
                new TestCase("a0b1c2", Set.of("a0b1c2", "0a1b2c", "0c2a1b")),
                new TestCase("leetcode", Set.of("")),
                
                new TestCase("ab123", Set.of("1a2b3"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reformat(test.in);
            assert test.expected.contains(actual) : "reformat('%s') = '%s', want any of %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String reformat(String s) {
        int digits = 0;
        int letters = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits++;
            } else {
                letters++;
            }
        }
        int diff = digits - letters;
        if (diff < -1 || diff > 1) {
            return "";
        }
        int digitIdx = (diff == 0 || diff == 1) ? 0 : 1;
        int letterIdx = (diff == 0 || diff == 1) ? 1 : 0;
        char[] result = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                result[digitIdx] = ch;
                digitIdx += 2;
            } else {
                result[letterIdx] = ch;
                letterIdx += 2;
            }
        }
        return new String(result);
    }

}