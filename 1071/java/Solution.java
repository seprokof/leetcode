class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String expected) {}

        TestCase[] tests = {
                new TestCase("ABCABC", "ABC", "ABC"),
                new TestCase("ABABAB", "ABAB", "AB"),
                new TestCase("LEET", "CODE", "")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.gcdOfStrings(test.in1, test.in2);
            assert test.expected.equals(actual) : "gcdOfStrings('%s', '%s') == '%s', want '%s'".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (str1.startsWith(str2)) {
            return str1.length() == str2.length() ? str1 : gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return "";
    }

}