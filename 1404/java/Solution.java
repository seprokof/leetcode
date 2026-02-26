class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("1101", 6),
                new TestCase("10", 1),
                new TestCase("1", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numSteps(test.in);
            assert test.expected == actual : "numSteps('%s') = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int numSteps(String s) {
        int carry = 0;
        int steps = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) + carry == '1') {
                carry = 1;
                steps += 2;
            } else {
                steps++;
            }
        }
        return steps + carry;
    }

}