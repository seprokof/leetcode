import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase("abbxxxxzzy", List.of(List.of(3, 6))),
                new TestCase("abc", List.of()),
                new TestCase("abcdddeeeeaabbbcd", List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14)))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.largeGroupPositions(test.in);
            assert Objects.equals(test.expected, actual) : "largeGroupPositions('%s') = %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        for (int left = 0, right = 1; right < s.length(); right++) {
            if (s.charAt(right - 1) != s.charAt(right)) {
                if (right - left >= 3) {
                    result.add(List.of(left, right - 1));
                }
                left = right;
            } else if (right == s.length() - 1 && right - left >= 2) {
                result.add(List.of(left, right));
            }
        }
        return result;
    }

}