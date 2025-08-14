import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("6777133339", "777"),
                new TestCase("2300019", "000"),
                new TestCase("42352338", "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.largestGoodInteger(test.in);
            assert Objects.equals(test.expected, actual) : "largestGoodInteger('%s') = '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    private static final String[] NUMBERS = { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };

    public String largestGoodInteger(String num) {
        for (String n : NUMBERS) {
            if (num.contains(n)) {
                return n;
            }
        }
        return "";
    }

}