import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, double expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 3, 50 }, { 7, 10 }, { 12, 25 } }, 10, 2.65D),
                new TestCase(new int[][] { { 1, 0 }, { 4, 25 }, { 5, 50 } }, 2, 0.25D),
                new TestCase(new int[][] { { 2, 50 } }, 0, 0D)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = s.calculateTax(test.in1, test.in2);
            assert test.expected == actual : "calculateTax(%s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    public double calculateTax(int[][] brackets, int income) {
        int i = 0;
        int previosLimit = 0;
        double tax = 0D;
        do {
            int currentIncome = Math.min(brackets[i][0], income) - previosLimit;
            tax += (currentIncome * brackets[i][1] / 100D);
            previosLimit = brackets[i][0];
        } while (i < brackets.length && brackets[i++][0] < income);
        return tax;
    }

}