class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}
        
        TestCase[] tests = {
                new TestCase(12, true),
                new TestCase(91, true),
                new TestCase(21, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkPowersOfThree(test.in);
            assert test.expected == actual : "checkPowersOfThree(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkPowersOfThree(int n) {
        if (n == 0) {
            return true;
        }
        if (n % 3 == 2) {
            return false;
        }
        return checkPowersOfThree(n / 3);
    }

}