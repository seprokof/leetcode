import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("bcabc", "abc"),
                new TestCase("cbacdcbc", "acdb")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.smallestSubsequence(test.in);
            assert Objects.equals(test.expected, actual) : "smallestSubsequence('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String smallestSubsequence(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int j = ch - 'a';
            frequency[j]--;
            if (visited[j]) {
                continue;
            }
            while (result.length() > 0) {
                int k = result.length() - 1;
                if (result.charAt(k) <= ch) {
                    break;
                }
                if (frequency[result.charAt(k) - 'a'] == 0) {
                    break;
                }
                visited[result.charAt(k) - 'a'] = false;
                result.deleteCharAt(k);
            }
            result.append(ch);
            visited[j] = true;
        }
        return result.toString();
    }

}