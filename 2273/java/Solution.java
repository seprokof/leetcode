import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, List<String> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "abba", "baba", "bbaa", "cd", "cd" }, List.of("abba", "cd")),
                new TestCase(new String[] { "a", "b", "c", "d", "e" }, List.of("a", "b", "c", "d", "e"))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.removeAnagrams(test.in);
            assert Objects.equals(test.expected, actual) : "removeAnagrams(%s) = %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public List<String> removeAnagrams(String[] words) {
        if (words.length == 1) {
            return List.of(words[0]);
        }
        List<String> result = new ArrayList<>(words.length);
        String leftWord = words[0];
        int[] leftFreq = getLetterFreq(leftWord);
        result.add(leftWord);
        for (int right = 1; right < words.length; right++) {
            String rightWord = words[right];
            int[] rightFreq = getLetterFreq(rightWord);
            if (!Arrays.equals(leftFreq, rightFreq)) {
                result.add(rightWord);
                leftWord = rightWord;
                leftFreq = rightFreq;
            }
        }
        return result;
    }

    private static int[] getLetterFreq(String word) {
        int[] freq = new int[26];
        for (char letter : word.toCharArray()) {
            freq[letter - 'a']++;
        }
        return freq;
    }

}