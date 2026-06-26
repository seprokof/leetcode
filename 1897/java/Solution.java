import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "abc", "aabc", "bc" }, true),
                new TestCase(new String[] { "ab", "a" }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.makeEqual(test.in);
            assert test.expected == actual : "makeEqual(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean makeEqual(String[] words) {
        int[] frequency = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                frequency[word.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (frequency[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }

}