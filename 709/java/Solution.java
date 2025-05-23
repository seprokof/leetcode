import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}
        
        TestCase[] tests = {
                new TestCase("Hello", "hello"),
                new TestCase("here", "here"),
                new TestCase("LOVELY", "lovely")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.toLowerCase(test.in);
            assert Objects.equals(test.expected, actual) : "toLowerCase('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}