class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(5, 7),
                new TestCase(10, 15),
                new TestCase(3, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.smallestNumber(test.in);
            assert test.expected == actual : "smallestNumber(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }
        return x;
    }

}