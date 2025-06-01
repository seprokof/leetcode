class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, long expected) {}
        
        TestCase[] tests = {
                new TestCase(5, 2, 3L),
                new TestCase(3, 3, 10L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.distributeCandies(test.in1, test.in2);
            assert test.expected == actual : "distributeCandies(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public long distributeCandies(int n, int limit) {
        long result = 0L;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            if (n - i > limit * 2) {
                continue;
            }
            result += Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1;
        }
        return result;
    }

}