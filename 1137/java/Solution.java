class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(4, 4),
                new TestCase(25, 1389537)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.tribonacci(test.in);
            assert test.expected == actual : "tribonacci(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int tribonacci(int n) {
        int[] queue = new int[] { 0, 1, 1 };
        if (n <= 2) {
            return queue[n];
        }
        for (int i = 3; i <= n; i++) {
            int next = queue[0] + queue[1] + queue[2];
            queue[0] = queue[1];
            queue[1] = queue[2];
            queue[2] = next;
        }
        return queue[2];
    }

}