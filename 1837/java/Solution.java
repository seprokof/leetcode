class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(34, 6, 9),
                new TestCase(10, 10, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumBase(test.in1, test.in2);
            assert test.expected == actual : "sumBase(%s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int sumBase(int n, int k) {
        int result = 0;
        while (n > 0) {
            result += n % k;
            n /= k;
        }
        return result;
    }

}