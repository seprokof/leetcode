import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String[] in2, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "word", "note", "ants", "wood" }, new String[] { "wood", "joke", "moat" }, List.of("word", "note", "wood")),
                new TestCase(new String[] { "yes" }, new String[] { "not" }, List.of())
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.twoEditWords(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "twoEditWords(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String d : dictionary) {
                int diff = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (d.charAt(i) != query.charAt(i)) {
                        diff++;
                    }
                }
                if (diff < 3) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }

}