class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase("1001010", 5, 5),
                new TestCase("00101001", 1, 6)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestSubsequence(test.in1, test.in2);
            assert test.expected == actual : "longestSubsequence('%s', %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int longestSubsequence(String s, int k) {
        double value = 0;
        int len = 0;
        for (int left = s.length() - 1; left >= 0; left--) {
            if (s.charAt(left) == '1') {
                if (value <= k) {
                    double temp = value + Math.pow(2, s.length() - 1 - left);
                    if (temp <= k) {
                        len++;
                        value = temp;
                    }
                }
            } else {
                len++;
            }
        }
        return len;
    }

}