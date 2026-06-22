import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("dart", 3, "tdar"),
                new TestCase("aaa", 1, "aaa")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.getEncryptedString(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "getEncryptedString('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String getEncryptedString(String s, int k) {
        int len = s.length();
        StringBuilder result = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            result.append(s.charAt((i + k) % len));
        }
        return result.toString();
    }

}