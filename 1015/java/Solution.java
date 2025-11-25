class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 1),
                new TestCase(2, -1),
                new TestCase(3, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.smallestRepunitDivByK(test.in);
            assert test.expected == actual : "smallestRepunitDivByK(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int rem = 0;
        for (int len = 1; len <= k; len++) {
            rem = (10 * rem + 1) % k;
            if (rem % k == 0) {
                return len;
            }
        }
        return -1;
    }

}