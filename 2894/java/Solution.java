class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}
        
        TestCase[] tests = {
                new TestCase(10, 3, 19),
                new TestCase(5, 6, 15),
                new TestCase(5, 1, -15)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.differenceOfSums(test.in1, test.in2);
            assert test.expected == actual : "differenceOfSums(%s, %s) == %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int differenceOfSums(int n, int m) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                result += i;
            } else {
                result -= i;
            }
        }
        return result;
    }

}