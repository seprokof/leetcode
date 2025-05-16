import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int[] in2, Set<List<String>> expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "bab", "dab", "cab"}, new int[] { 1, 2, 2 }, Set.of(List.of("bab", "cab"), List.of("bab", "dab"))),
                new TestCase(new String[] { "a", "b", "c", "d" }, new int[] { 1, 2, 3, 4 }, Set.of(List.of("a", "b", "c", "d")))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<String> actual = s.getWordsInLongestSubsequence(test.in1, test.in2);
            assert test.expected.contains(actual) : "getWordsInLongestSubsequence(%s, %s) == %s, want any of %s"
                    .formatted(Arrays.toString(test.in1), Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int[] dp = new int[words.length];
        int[] previousIdx = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            previousIdx[i] = -1;
        }
        int idxPrev = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && validHammingDistance(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    previousIdx[i] = j;
                }
            }
            if (dp[idxPrev] < dp[i]) {
                idxPrev = i;
            }
        }
        List<String> result = new ArrayList<>(dp[words.length - 1]);
        for (int i = idxPrev; i >= 0; i = previousIdx[i]) {
            result.add(words[i]);
        }
        Collections.reverse(result);
        return result;
    }

    private static boolean validHammingDistance(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < s1.length() && result < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }
        return result == 1;
    }

}