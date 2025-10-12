class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(3, 5, 1),
                new TestCase(5, 6, 2),
                new TestCase(4, 2, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfChild(test.in1, test.in2);
            assert test.expected == actual : "numberOfChild(%s, %s) = %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int numberOfChild(int n, int k) {
        int idx = k % --n;
        if ((k / n) % 2 == 0) {
            return idx;
        } else {
            return n - idx;
        }
    }

}