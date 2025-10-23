class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("3902", true),
                new TestCase("34789", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.hasSameDigits(test.in);
            assert test.expected == actual : "hasSameDigits('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean hasSameDigits(String s) {
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < digits.length - 2; i++) {
            for (int j = 1; j < digits.length - i; j++) {
                digits[j - 1] = (digits[j] + digits[j - 1]) % 10;
            }
        }
        return digits[0] == digits[1];
    }

}