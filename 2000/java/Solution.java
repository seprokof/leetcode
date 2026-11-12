import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, char in2, String expected) {}

        TestCase[] tests = {
                new TestCase("abcdefd", 'd', "dcbaefd"),
                new TestCase("xyxzxe", 'z', "zxyxxe"),
                new TestCase("abcd", 'z', "abcd")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reversePrefix(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "reversePrefix('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx < 0) {
            return word;
        }
        char[] strArr = word.toCharArray();
        for (int i = 0; i <= idx / 2; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[idx - i];
            strArr[idx - i] = temp;
        }
        return new String(strArr);
    }

}