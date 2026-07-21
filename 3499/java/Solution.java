class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("01", 1),
                new TestCase("0100", 4),
                new TestCase("1000100", 7),
                new TestCase("01010", 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxActiveSectionsAfterTrade(test.in);
            assert test.expected == actual : "maxActiveSectionsAfterTrade('%s') == %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public int maxActiveSectionsAfterTrade(String s) {
        int sec1Len = 0;
        int sec2Len = 0;
        int oneCount = 0;
        int maxLen = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                sec1Len++;
                i++;
            } else {
                while (i < s.length() && s.charAt(i) == '1') {
                    oneCount++;
                    i++;
                }
                while (i < s.length() && s.charAt(i) == '0') {
                    sec2Len++;
                    i++;
                }
                if (sec1Len > 0 && sec2Len > 0) {
                    maxLen = Math.max(maxLen, sec1Len + sec2Len);
                }
                sec1Len = sec2Len;
                sec2Len = 0;
            }
        }
        return oneCount + maxLen;
    }

}