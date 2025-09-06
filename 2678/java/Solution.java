import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "7868190130M7522", "5303914400F9211", "9273338290F4010" }, 2),
                new TestCase(new String[] { "1313579440F2036", "2921522980M5644" }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countSeniors(test.in);
            assert test.expected == actual : "countSeniors(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int countSeniors(String[] details) {
        int result = 0;
        for (String detail : details) {
            char ch = detail.charAt(11);
            if (ch > '6' || (ch == '6' && detail.charAt(12) > '0')) {
                result++;
            }
        }
        return result;
    }

}