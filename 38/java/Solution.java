import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, String expected) {}

        TestCase[] tests = {
                new TestCase(4, "1211"),
                new TestCase(1, "1")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.countAndSay(test.in);
            assert Objects.equals(test.expected, actual) : "countPairs(%s) == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            str = rle(str);
        }
        return str;
    }

    private static String rle(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(count);
                result.append(str.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count);
        result.append(str.charAt(str.length() - 1));
        return result.toString();
    }

}