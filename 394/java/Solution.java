import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("3[a]2[bc]", "aaabcbc"),
                new TestCase("3[a2[c]]", "accaccacc"),
                new TestCase("2[abc]3[cd]ef", "abcabccdcdcdef")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.decodeString(test.in);
            assert test.expected.equals(actual) : "decodeString('%s') == '%s', want '%s'".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String decodeString(String s) {

        record BlockMetadata(Integer times, Integer startIdx) {
        }

        StringBuilder result = new StringBuilder();
        int multiplierStartIdx = -1;
        Deque<BlockMetadata> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9' && multiplierStartIdx == -1) {
                multiplierStartIdx = i;
            } else if (ch == '[') {
                stack.push(new BlockMetadata(Integer.parseInt(s.substring(multiplierStartIdx, i)), result.length()));
                multiplierStartIdx = -1;
            } else if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            } else if (ch == ']') {
                BlockMetadata blockMd = stack.pop();
                int endIdx = result.length();
                for (int j = 1; j < blockMd.times; j++) {
                    result.append(result, blockMd.startIdx, endIdx);
                }
            }
        }
        return result.toString();
    }

}