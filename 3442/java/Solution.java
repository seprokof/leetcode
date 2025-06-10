class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}
        
        TestCase[] tests = {
                new TestCase("aaaaabbc", 3),
                new TestCase("abcabcab", 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDifference(test.in);
            assert test.expected == actual : "maxDifference('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 0) {
                    minEven = Math.min(minEven, f);
                } else {
                    maxOdd = Math.max(maxOdd, f);
                }
            }
        }
        return maxOdd - minEven;
    }

}