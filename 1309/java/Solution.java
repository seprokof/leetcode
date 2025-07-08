import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("10#11#12", "jkab"),
                new TestCase("1326#", "acz")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.freqAlphabets(test.in);
            assert Objects.equals(test.expected, actual) : "freqAlphabets('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            String subStr;
            if (s.charAt(i) == '#') {
                subStr = s.substring(i - 2, i);
                i -= 2;
            } else {
                subStr = s.substring(i, i + 1);
            }
            int num = Integer.parseInt(subStr);
            result.append((char) ('a' + num - 1));
        }
        return result.reverse().toString();
    }

}