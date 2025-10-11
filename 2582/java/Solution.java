class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(4, 5, 2),
                new TestCase(3, 2, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.passThePillow(test.in1, test.in2);
            assert test.expected == actual : "passThePillow(%s, %s) = %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int passThePillow(int n, int time) {
        int idx = time % (n - 1);
        if ((time / (n - 1)) % 2 == 0) {
            return idx + 1;
        } else {
            return n - idx;
        }
    }

}