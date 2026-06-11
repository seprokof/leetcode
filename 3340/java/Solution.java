class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("1234", false),
                new TestCase("24123", true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isBalanced(test.in);
            assert test.expected == actual : "isBalanced(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public boolean isBalanced(String num) {
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                sum += num.charAt(i) - '0';
            } else {
                sum -= num.charAt(i) - '0';
            }
        }
        return sum == 0;
    }

}