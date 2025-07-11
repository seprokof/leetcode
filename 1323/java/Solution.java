class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(9669, 9969),
                new TestCase(9996, 9999),
                new TestCase(9999, 9999)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximum69Number(test.in);
            assert test.expected == actual : "maximum69Number(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int maximum69Number(int num) {
        int result = 0;
        for (int divisor = 1000; divisor > 0; divisor /= 10) {
            int digit = num / divisor;
            if (digit == 6) {
                return result + 9 * divisor + num % divisor;
            } else {
                result += digit * divisor;
                num %= divisor;
            }
        }
        return result;
    }

}