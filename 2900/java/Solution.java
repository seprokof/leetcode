import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int[] in2, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "e", "a", "b" }, new int[] { 0, 0, 1 }, List.of("e", "b")),
                new TestCase(new String[] { "a", "b", "c", "d" }, new int[] { 1, 0, 1, 1 }, List.of("a", "b", "c"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.getLongestSubsequence(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "getLongestSubsequence(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>(words.length);
        int prevGroup = -1;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] != prevGroup) {
                result.add(words[i]);
                prevGroup = groups[i];
            }
        }
        return result;
    }

}