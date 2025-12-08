class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(5, 2),
                new TestCase(10, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countTriples(test.in);
            assert test.expected == actual : "countTriples(%s) = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int countTriples(int n) {
        int sqrN = n * n;
        int result = 0;
        for (int a = 1; a < n - 1; a++) {
            int sqrA = a * a;
            for (int b = a + 1; b < n; b++) {
                int sqrSum = sqrA + b * b;
                if (sqrSum > sqrN) {
                    break;
                }
                double c = Math.sqrt(sqrSum);
                if (c == (int) c) {
                    result++;
                }
            }
        }
        return result * 2;
    }

}