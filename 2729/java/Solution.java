class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(192, true),
                new TestCase(100, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isFascinating(test.in);
            assert test.expected == actual : "isFascinating(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean isFascinating(int n) {
        boolean[] digits = new boolean[10];
        for (int i = 1; i < 4; i++) {
            int value = n * i;
            while (value > 0) {
                int digit = value % 10;
                if (digit == 0 || digits[digit]) {
                    return false;
                }
                digits[digit] = true;
                value /= 10;
            }
        }
        for (int i = 1; i < 10; i++) {
            if (!digits[i]) {
                return false;
            }
        }
        return true;
    }

}