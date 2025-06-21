class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase("aabcaba", 0, 3),
                new TestCase("dabdcbdcdcd", 2, 2),
                new TestCase("aaabaaa", 2, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumDeletions(test.in1, test.in2);
            assert test.expected == actual : "minimumDeletions('%s', %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        int result = word.length();
        for (int x : freq) {
            if (x == 0) {
                continue;
            }
            int deletedCount = 0;
            for (int y : freq) {
                if (y < x) {
                    deletedCount += y;
                } else if (y > x + k) {
                    deletedCount += (y - x - k);
                }
            }
            result = Math.min(result, deletedCount);
        }
        return result;
    }

}