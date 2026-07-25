class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(31, 3),
                new TestCase(22, 4),
                new TestCase(124, 8)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxProduct(test.in);
            assert test.expected == actual : "maxProduct(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit >= max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
            n /= 10;
        }
        return max1 * max2;
    }

}