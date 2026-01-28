import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("  this   is  a sentence ", "this   is   a   sentence"),
                new TestCase(" practice   makes   perfect", "practice   makes   perfect ")
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reorderSpaces(test.in);
            assert Objects.equals(test.expected, actual) : "reorderSpaces('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int spaces = 0;
        char previous = ' ';
        int words = 0;
        for (char current : chars) {
            if (current == ' ') {
                spaces++;
                if (previous != ' ') {
                    words++;
                }
            }
            previous = current;
        }
        if (previous != ' ') {
            words++;
        }
        int between = words == 1 ? 0 : spaces / (words - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (chars[i] == ' ') {
            i++;
        }
        while (i < chars.length) {
            if (chars[i] == ' ') {
                sb.repeat(' ', Math.min(between, spaces));
                spaces -= between;
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
            } else {
                sb.append(chars[i]);
                i++;
            }
        }
        if (spaces > 0) {
            sb.repeat(' ', spaces);
        }
        return sb.toString();
    }

}