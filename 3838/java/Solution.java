import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int[] in2, String expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "abcd", "def", "xyz" }, new int[] { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 }, "rij"),
                new TestCase(new String[] { "a", "b", "c" }, new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, "yyy"),
                new TestCase(new String[] { "abcd" }, new int[] { 7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5 }, "g")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.mapWordWeights(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "mapWordWeights(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            int weight = 0;
            for (int i = 0; i < word.length(); i++) {
                weight += weights[word.charAt(i) - 'a'];
            }
            sb.append((char) ('a' + 25 - weight % 26));
        }
        return sb.toString();
    }

}