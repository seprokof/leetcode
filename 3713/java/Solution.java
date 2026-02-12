class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abbac", 4),
                new TestCase("zzabccy", 4),
                new TestCase("aba", 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestBalanced(test.in);
            assert test.expected == actual : "longestBalanced('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int longestBalanced(String s) {
        char[] str = s.toCharArray();
        int result = 0;
        for (int i = 0; i < s.length() - result; i++) {
            int[] freq = new int[26];
            int uniqueCount = 0;
            int localMaxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                int f = ++freq[str[j] - 'a'];
                if (f == 1) {
                    uniqueCount++;
                }
                localMaxFreq = Math.max(localMaxFreq, f);
                int len = j - i + 1;
                if (uniqueCount * localMaxFreq == len) {
                    result = Math.max(result, len);
                }
            }
        }
        return result;
    }

}