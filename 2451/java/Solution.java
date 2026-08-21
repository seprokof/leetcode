import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, String expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "adc", "wzy", "abc" }, "abc"),
                new TestCase(new String[] { "aaa", "bob", "ccc", "ddd" }, "bob")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.oddString(test.in);
            assert Objects.equals(test.expected, actual) : "oddString(%s) == '%s', want '%s'"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public String oddString(String[] words) {
        for (int i = 1; i < words[0].length(); i++) {
            int diff1 = words[0].charAt(i) - words[0].charAt(i - 1);
            int diff2 = words[1].charAt(i) - words[1].charAt(i - 1);
            for (int j = 2; j < words.length; j++) {
                int diff3 = words[j].charAt(i) - words[j].charAt(i - 1);
                if (diff1 != diff2) {
                    if (diff1 == diff3) {
                        return words[1];
                    } else {
                        return words[0];
                    }
                } else if (diff2 != diff3) {
                    if (diff1 == diff2) {
                        return words[j];
                    } else {
                        return words[1];
                    }
                }
            }
        }
        return null;
    }

}