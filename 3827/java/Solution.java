class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(1, 2),
                new TestCase(4, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countMonobit(test.in);
            assert test.expected == actual : "countMonobit(%s) == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int countMonobit(int n) {
        int result = 0;
        for (int num = 0, pow = 0; num <= n; pow++, result++) {
            num += 1 << pow;
        }
        return result;
    }

}