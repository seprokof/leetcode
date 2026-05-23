class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1234, 3412),
                new TestCase(65875, 87655)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.largestInteger(test.in);
            assert test.expected == actual : "largestInteger(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int largestInteger(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] < digits[j] && (digits[j] - digits[i]) % 2 == 0) {
                    char tmp = digits[i];
                    digits[i] = digits[j];
                    digits[j] = tmp;
                }
            }
        }
        return Integer.parseInt(String.valueOf(digits));
    }

}