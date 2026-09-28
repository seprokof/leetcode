class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(6, true),
                new TestCase(5, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.consecutiveSetBits(test.in);
            assert test.expected == actual : "consecutiveSetBits(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean consecutiveSetBits(int n) {
        int prev = 0;
        boolean seen = false;
        while (n > 0) {
            int rem = n % 2;
            if (rem == 1 && prev == 1) {
                if (seen) {
                    return false;
                } else {
                    seen = true;
                }
            }
            prev = rem;
            n /= 2;
        }
        return seen;
    }

}