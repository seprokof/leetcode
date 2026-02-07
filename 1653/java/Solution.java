class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("aababbab", 2),
                new TestCase("bbaaaaabb", 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumDeletions(test.in);
            assert test.expected == actual : "minimumDeletions('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minimumDeletions(String s) {
        int bCount = 0;
        int result = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                bCount++;
            } else if (bCount > 0) {
                result++;
                bCount--;
            }
        }
        return result;
    }

}