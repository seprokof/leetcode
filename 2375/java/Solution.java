import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}
        
        TestCase[] tests = {
                new TestCase("IIIDIDDD", "123549876"),
                new TestCase("DDD", "4321")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.smallestNumber(test.in);
            assert Objects.equals(test.expected, actual) : "smallestNumber('%s') == '%s', want '%s'".formatted(test.in,
                    actual, test.expected);
        }
    }

    public String smallestNumber(String pattern) {
        return build(pattern, 0, new StringBuilder(), new boolean[pattern.length() + 2], '\u0000', -1);
    }

    private String build(String pattern, int currentIdx, StringBuilder result, boolean[] used, char previousPattern,
            int previousDigit) {
        for (int i = 1; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            if ((previousPattern == 'I' && previousDigit < i) || (previousPattern == 'D' && previousDigit > i)
                    || previousPattern == '\u0000') {
                used[i] = true;
                result.append(i);
                if (currentIdx == pattern.length()) {
                    return result.toString();
                }
                String res = build(pattern, currentIdx + 1, result, used, pattern.charAt(currentIdx), i);
                if (res != null) {
                    return res;
                }
                used[i] = false;
                result.setLength(result.length() - 1);
            }
        }
        return null;
    }

}