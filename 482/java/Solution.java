import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}
        
        TestCase[] tests = {
                new TestCase("5F3Z-2e-9-w", 4, "5F3Z-2E9W"),
                new TestCase("2-5g-3-J", 2, "2-5G-3J")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.licenseKeyFormatting(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "licenseKeyFormatting('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder str = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                str.append(Character.toUpperCase(ch));
            }
        }
        int len = str.length();
        if (len == 0) {
            return "";
        }
        int i = len % k;
        if (i > 0) {
            str.append(str.substring(0, i)).append('-');
        }
        for (; i + k <= len; i += k) {
            str.append(str.substring(i, i + k)).append('-');
        }
        return str.substring(len, str.length() - 1);
    }

}