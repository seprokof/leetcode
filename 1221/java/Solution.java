class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("RLRRLLRLRL", 4),
                new TestCase("RLRRRLLRLL", 2),
                new TestCase("LLLLRRRR", 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.balancedStringSplit(test.in);
            assert test.expected == actual : "balancedStringSplit('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int balancedStringSplit(String s) {
        int lCount = 0;
        int rCount = 0;
        int result = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            if (lCount == rCount) {
                result++;
                lCount = 0;
                rCount = 0;
            }
        }
        return result;
    }

}