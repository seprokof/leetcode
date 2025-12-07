class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(3, 7, 3),
                new TestCase(8, 10, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countOdds(test.in1, test.in2);
            assert test.expected == actual : "countOdds(%s, %s) = %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }

}