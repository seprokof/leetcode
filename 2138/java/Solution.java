import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, char in3, String[] expected) {}
        
        TestCase[] tests = {
                new TestCase("abcdefghi", 3, 'x', new String[] { "abc", "def", "ghi" }),
                new TestCase("abcdefghij", 3, 'x', new String[] { "abc", "def", "ghi", "jxx" })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.divideString(test.in1, test.in2, test.in3);
            assert Arrays.equals(test.expected, actual) : "divideString('%s', %s, '%s') == %s, want %s"
                    .formatted(test.in1, test.in2, test.in3, Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        String[] result = new String[len / k + (len % k == 0 ? 0 : 1)];
        char[] sArr = s.toCharArray();
        StringBuilder sb = null;
        for (int i = 0; i < len; i++) {
            if (i % k == 0) {
                if (sb != null) {
                    result[i / k - 1] = sb.toString();
                }
                sb = new StringBuilder();
            }
            sb.append(sArr[i]);
        }
        while (sb.length() % k != 0) {
            sb.append(fill);
        }
        result[result.length - 1] = sb.toString();
        return result;
    }

}