class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 2),
                new TestCase(3, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.climbStairs(test.in);
            assert test.expected == actual : "climbStairs(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int climbStairs(int n) {
        int previous = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current += previous;
            previous = temp;
        }
        return current;
    }

}