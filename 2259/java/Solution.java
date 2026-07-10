import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, char in2, String expected) {}

        TestCase[] tests = {
                new TestCase("123", '3', "12"),
                new TestCase("1231", '1', "231"),
                new TestCase("551", '5', "51")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.removeDigit(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "removeDigit('%s', %s) == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String removeDigit(String number, char digit) {
        for (int i = 1; i < number.length(); i++) {
            if (number.charAt(i - 1) == digit && number.charAt(i) > number.charAt(i - 1)) {
                return number.substring(0, i - 1) + number.substring(i, number.length());
            }
        }
        int lastIndex = number.lastIndexOf(digit);
        return number.substring(0, lastIndex) + number.substring(lastIndex + 1, number.length());
    }

}