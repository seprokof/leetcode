class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase("iiii", 1, 36),
                new TestCase("leetcode", 2, 6),
                new TestCase("zbax", 2, 8)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.getLucky(test.in1, test.in2);
            assert test.expected == actual : "getLucky('%s', %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int getLucky(String s, int k) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += digitSum(s.charAt(i) - '`');
        }
        for (int i = 1; i < k; i++) {
            result = digitSum(result);
        }
        return result;
    }

    private static int digitSum(int num) {
        int result = 0;
        while (num > 0) {
            int digit = num % 10;
            result += digit;
            num /= 10;
        }
        return result;
    }

}