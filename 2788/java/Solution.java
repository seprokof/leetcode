import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(List<String> in1, char in2, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(List.of("one.two.three", "four.five","six"), '.', List.of("one", "two", "three", "four", "five", "six")),
                new TestCase(List.of("$easy$", "$problem$"), '$', List.of("easy", "problem")),
                new TestCase(List.of("|||"), '|', List.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.splitWordsBySeparator(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "splitWordsBySeparator(%s, %s) = %s, want %s"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int start = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (i > start) {
                        result.add(word.substring(start, i));
                    }
                    start = i + 1;
                }
            }
            if (word.length() > start) {
                result.add(word.substring(start, word.length()));
            }
        }
        return result;
    }

}