class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(5, 2, 3),
                new TestCase(3, 3, 10)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.distributeCandies(test.in1, test.in2);
            assert test.expected == actual : "distributeCandies(%s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int distributeCandies(int n, int limit) {
        int result = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            if (n - i > limit * 2) {
                continue;
            }
            result += Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1;
        }
        return result;
    }

}