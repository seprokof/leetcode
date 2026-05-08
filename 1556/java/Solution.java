import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, String expected) {}

        TestCase[] tests = {
                new TestCase(987, "987"),
                new TestCase(1234, "1.234")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.thousandSeparator(test.in);
            assert Objects.equals(test.expected, actual) : "thousandSeparator(%s) = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String thousandSeparator(int n) {
        String nStr = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nStr.length(); i++) {
            if ((nStr.length() - i) % 3 == 0 && i > 0) {
                sb.append('.');
            }
            sb.append(nStr.charAt(i));
        }
        return sb.toString();
    }

}