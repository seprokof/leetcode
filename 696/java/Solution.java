class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("00110011", 6),
                new TestCase("10101", 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countBinarySubstrings(test.in);
            assert test.expected == actual : "countBinarySubstrings('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countBinarySubstrings(String s) {
        if (s.length() == 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int previousLen = 0;
        int currentLen = 1;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (arr[i - 1] == arr[i]) {
                currentLen++;
            } else {
                result += Math.min(previousLen, currentLen);
                previousLen = currentLen;
                currentLen = 1;
            }
        }
        result += Math.min(previousLen, currentLen);
        return result;
    }

}