class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(22, 2),
                new TestCase(8, 0),
                new TestCase(5, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.binaryGap(test.in);
            assert test.expected == actual : "binaryGap(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int binaryGap(int n) {
        int previous = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; n > 0; i++) {
            if (n % 2 == 1) {
                max = Math.max(max, i - previous);
                previous = i;
            }
            n /= 2;
        }
        return max;
    }

}