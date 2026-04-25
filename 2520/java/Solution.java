class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(7, 1),
                new TestCase(121, 2),
                new TestCase(1248, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countDigits(test.in);
            assert test.expected == actual : "countDigits(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int countDigits(int num) {
        int result = 0;
        for (int n = num; n != 0; n /= 10) {
            int digit = n % 10;
            if (num % digit == 0) {
                result++;
            }
        }
        return result;
    }

}