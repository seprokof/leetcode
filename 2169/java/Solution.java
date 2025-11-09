class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 3, 3),
                new TestCase(10, 10, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countOperations(test.in1, test.in2);
            assert test.expected == actual : "countOperations(%s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        int big = num1 > num2 ? num1 : num2;
        int small = num1 < num2 ? num1 : num2;
        return big / small + countOperations(big % small, small);
    }

}