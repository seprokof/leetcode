import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "alic3", "bob", "3", "4", "00000" }, 5),
                new TestCase(new String[] { "1", "01", "001", "0001" }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumValue(test.in);
            assert test.expected == actual : "maximumValue(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maximumValue(String[] strs) {
        int result = -1;
        s: for (String str : strs) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    result = Math.max(result, str.length());
                    continue s;
                }
            }
            result = Math.max(result, Integer.valueOf(str));
        }
        return result;
    }

}