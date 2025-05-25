import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new String[] { "lc", "cl", "gg" }, 6),
                new TestCase(new String[] { "ab", "ty", "yt", "lc", "cl", "ab" }, 8),
                new TestCase(new String[] { "cc", "ll", "xx" }, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestPalindrome(test.in);
            assert test.expected == actual : "longestPalindrome(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> available = new HashMap<>(words.length);
        for (String word : words) {
            available.merge(word, 1, Integer::sum);
        }
        int result = 0;
        for (Map.Entry<String, Integer> wordWithCount : available.entrySet()) {
            Integer count = wordWithCount.getValue();
            if (count == 0) {
                continue;
            }
            String word = wordWithCount.getKey();
            String reversed = String.valueOf(new char[] { word.charAt(1), word.charAt(0) });
            if (reversed.equals(word)) {
                result += (count - (count % 2 != 0 && result % 2 != 0 ? 1 : 0));
            } else {
                int countReversed = available.getOrDefault(reversed, 0);
                result += (Math.min(wordWithCount.getValue(), countReversed) * 2);
                if (countReversed > 0) {
                    available.put(reversed, 0);
                }
            }
        }
        return result * 2;
    }

}