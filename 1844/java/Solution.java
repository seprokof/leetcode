import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("a1c1e1", "abcdef"),
                new TestCase("a1b2c3d4e", "abbdcfdhe")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.replaceDigits(test.in);
            assert Objects.equals(test.expected, actual) : "replaceDigits('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) (arr[i - 1] + arr[i] - '0');
        }
        return String.valueOf(arr);
    }

}