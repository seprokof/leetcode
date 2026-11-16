import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, String expected) {}

        TestCase[] tests = {
                new TestCase("11111222223", 3, "135"),
                new TestCase("00000000", 3, "000")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.digitSum(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "digitSum('%s', %s) == '%s', want '%s'".formatted(test.in1,
                    test.in2, actual, test.expected);
        }
    }

    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - '0');
            if ((i + 1) % k == 0) {
                sb.append(sum);
                sum = 0;
            }
        }
        if (s.length() % k != 0) {
            sb.append(sum);
        }
        return digitSum(sb.toString(), k);
    }

}