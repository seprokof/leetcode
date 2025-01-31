import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int[] in2, String expected) {}

        TestCase[] tests = {
                new TestCase("LeetcodeHelpsMeLearn", new int[] { 8, 13, 15 }, "Leetcode Helps Me Learn"),
                new TestCase("icodeinpython", new int[] { 1, 5, 7, 9 }, "i code in py thon"),
                new TestCase("spacing", new int[] { 0, 1, 2, 3, 4, 5, 6 }, " s p a c i n g")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.addSpaces(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "addSpaces('%s', %s) == %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public String addSpaces(String s, int[] spaces) {
        int start = 0;
        StringBuilder sb = new StringBuilder(s.length() + spaces.length);
        for (int spaceIdx : spaces) {
            sb.append(s.substring(start, spaceIdx)).append(' ');
            start = spaceIdx;
        }
        sb.append(s.substring(start));
        return sb.toString();
    }

}