import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String expected) {}

        TestCase[] tests = {
                new TestCase("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv", "this is a secret"),
                new TestCase("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb", "the five boxing wizards jump quickly")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.decodeMessage(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "decodeMessage('%s', '%s') = '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String decodeMessage(String key, String message) {
        char[] mapping = new char[26];
        int i = 0;
        for (char ch : key.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (mapping[ch - 'a'] == Character.MIN_VALUE) {
                mapping[ch - 'a'] = (char) ('a' + i);
                i++;
            }
        }
        StringBuilder sb = new StringBuilder(message.length());
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                sb.append(' ');
            } else {
                sb.append(mapping[ch - 'a']);
            }
        }
        return sb.toString();
    }

}