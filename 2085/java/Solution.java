import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "leetcode", "is", "amazing", "as", "is" }, new String[] { "amazing", "leetcode", "is" }, 2),
                new TestCase(new String[] { "b", "bb", "bbb" }, new String[] { "a", "aa", "aaa" }, 0),
                new TestCase(new String[] { "a", "ab" }, new String[] { "a", "a", "a", "ab" }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countWords(test.in1, test.in2);
            assert test.expected == actual : "countWords(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int countWords(String[] words1, String[] words2) {
        Set<String> unique1 = new HashSet<>();
        Set<String> words = new HashSet<>();
        Set<String> unique2 = new HashSet<>();
        for (String word : words1) {
            if (unique1.add(word)) {
                words.add(word);
            } else {
                words.remove(word);
            }
        }
        int result = 0;
        for (String word : words2) {
            if (unique2.add(word)) {
                if (words.contains(word)) {
                    result++;
                }
            } else {
                if (words.contains(word)) {
                    words.remove(word);
                    result--;
                }
            }
        }
        return result;
    }

}