import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("aabca", 3),
                new TestCase("adc", 0),
                new TestCase("bbcbaba", 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countPalindromicSubsequence(test.in);
            assert test.expected == actual : "countPalindromicSubsequence('%s') = %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public int countPalindromicSubsequence(String s) {
        List<Integer>[] positions = new ArrayList[26];
        for (int i = 0; i < s.length(); i++) {
            List<Integer> letterPos = positions[s.charAt(i) - 'a'];
            if (letterPos == null) {
                letterPos = new ArrayList<>();
                positions[s.charAt(i) - 'a'] = letterPos;
            }
            letterPos.add(i);
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> letterPos = positions[i];
            if (letterPos == null || letterPos.size() < 2) {
                continue;
            }
            Integer startPos = letterPos.getFirst();
            Integer endPos = letterPos.getLast();
            for (int j = 0; j < 26; j++) {
                if (positions[j] == null) {
                    continue;
                }
                for (Integer k : positions[j]) {
                    if (startPos < k && k < endPos) {
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }

}