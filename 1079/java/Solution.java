class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}
        
        TestCase[] tests = {
                new TestCase("AAB", 8),
                new TestCase("AAABBC", 188),
                new TestCase("V", 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numTilePossibilities(test.in);
            assert test.expected == actual : "numTilePossibilities('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int numTilePossibilities(String tiles) {
        int[] frequency = new int[26];
        for (char ch : tiles.toCharArray()) {
            frequency[ch - 'A']++;
        }
        return backtrack(frequency);
    }

    private static int backtrack(int[] remaining) {
        int result = 0;
        for (int i = 0; i < remaining.length; i++) {
            if (remaining[i] > 0) {
                remaining[i]--;
                result++;
                result += backtrack(remaining);
                remaining[i]++;
            }
        }
        return result;
    }

}