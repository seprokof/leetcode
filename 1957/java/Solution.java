import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("leeetcode", "leetcode"),
                new TestCase("aaabaaaa", "aabaa"),
                new TestCase("aab", "aab")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.makeFancyString(test.in);
            assert Objects.equals(test.expected, actual) : "makeFancyString('%s') = '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String makeFancyString(String s) {
        char[] strArr = s.toCharArray();
        int insertPos = Math.min(2, strArr.length);
        for (int i = 2; i < strArr.length; i++) {
            strArr[insertPos] = strArr[i];
            if (strArr[i] != strArr[insertPos - 1] || strArr[i] != strArr[insertPos - 2]) {
                insertPos++;
            }
        }
        return new String(Arrays.copyOf(strArr, insertPos));
    }

}