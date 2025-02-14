import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String expected) {}
        
        TestCase[] tests = {
                new TestCase("11", "123", "134"),
                new TestCase("456", "77", "533"),
                new TestCase("0", "0", "0")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.addStrings(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "addStrings('%s', '%s') == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || reminder > 0; i--, j--) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = digit1 + digit2 + reminder;
            sb.append(sum % 10);
            reminder = sum / 10;
        }
        return sb.reverse().toString();
    }

}