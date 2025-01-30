import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, List<Integer> expected) {}

        TestCase[] tests = {
                new TestCase("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
                new TestCase("eccbbbbdec", List.of(10))
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<Integer> actual = s.partitionLabels(test.in);
            assert Objects.equals(test.expected, actual) : "partitionLabels('%s') == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public List<Integer> partitionLabels(String s) {
        int[] letterPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterPos[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int startIdx = 0;
        int endIdx;
        while (startIdx < s.length()) {
            endIdx = letterPos[s.charAt(startIdx) - 'a'];
            for (int i = startIdx; i < endIdx; i++) {
                endIdx = Math.max(endIdx, letterPos[s.charAt(i) - 'a']);
            }
            result.add(endIdx - startIdx + 1);
            startIdx = endIdx + 1;
        }
        return result;
    }

}