import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "aba", "aabb", "abcd", "bac", "aabc" }, 2),
                new TestCase(new String[] { "aabb", "ab", "ba" }, 3),
                new TestCase(new String[] { "nba", "cba", "dba" }, 0),
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.similarPairs(test.in);
            assert test.expected == actual : "similarPairs(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int similarPairs(String[] words) {
        boolean[][] letters = new boolean[words.length][];
        letters[0] = getUniqueLetters(words[0]);
        int pairsCount = 0;
        for (int i = 1; i < words.length; i++) {
            letters[i] = getUniqueLetters(words[i]);
            if (Arrays.equals(letters[0], letters[i])) {
                pairsCount++;
            }
        }
        for (int i = 1; i < words.length - 1; i++) {
            for (int j = i + 1; j < letters.length; j++) {
                if (Arrays.equals(letters[i], letters[j])) {
                    pairsCount++;
                }
            }
        }
        return pairsCount;
    }

    private static boolean[] getUniqueLetters(String word) {
        boolean[] letters = new boolean[26];
        for (char ch : word.toCharArray()) {
            letters[ch - 'a'] = true;
        }
        return letters;
    }

}