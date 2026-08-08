import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("2080-02-29", "100000100000-10-11101"),
                new TestCase("1900-01-01", "11101101100-1-1")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.convertDateToBinary(test.in);
            assert Objects.equals(test.expected, actual) : "convertDateToBinary('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String convertDateToBinary(String date) {
        String year = Integer.toBinaryString(Integer.valueOf(date.substring(0, 4)));
        String month = Integer.toBinaryString(Integer.valueOf(date.substring(5, 7)));
        String day = Integer.toBinaryString(Integer.valueOf(date.substring(8, 10)));
        return new StringBuilder().append(year).append("-").append(month).append("-").append(day).toString();
    }

}