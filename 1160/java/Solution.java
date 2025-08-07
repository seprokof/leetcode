import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "cat", "bt", "hat", "tree" }, "atach", 6),
                new TestCase(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr", 10)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countCharacters(test.in1, test.in2);
            assert test.expected == actual : "countCharacters(%s, '%s') = %s, want %s"
                    .formatted(Arrays.toString(test.in1), actual, test.expected);
        }
    }

    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for (char letter : chars.toCharArray()) {
            freq[letter - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            if (canCreate(word, freq)) {
                result += word.length();
            }
        }
        return result;
    }

    private static boolean canCreate(String word, int[] availableFrequency) {
        int[] freq = new int[26];
        for (char letter : word.toCharArray()) {
            int idx = letter - 'a';
            freq[idx]++;
            if (freq[idx] > availableFrequency[idx]) {
                return false;
            }
        }
        return true;
    }

}