class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("bcbbbcba", 4),
                new TestCase("aaaa", 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximumLengthSubstring(test.in);
            assert test.expected == actual : "maximumLengthSubstring('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maximumLengthSubstring(String s) {
        int[] frequency = new int[26];
        int start = 0;
        int result = 0;
        for (int end = 0; end < s.length(); end++) {
            int index = s.charAt(end) - 'a';
            if (++frequency[index] > 2) {
                result = Math.max(result, end - start);
                while (frequency[index] > 2) {
                    frequency[s.charAt(start++) - 'a']--;
                }
            }
        }
        return Math.max(result, s.length() - start);
    }

}