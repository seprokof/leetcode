class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int in3, double expected) {}

        TestCase[] tests = {
                new TestCase(1, 1, 1, 0.0),
                new TestCase(2, 1, 1, 0.5),
                new TestCase(100000009, 33, 17, 1.0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = s.champagneTower(test.in1, test.in2, test.in3);
            assert test.expected == actual : "champagneTower(%s, %s, %s) = %s, want %s".formatted(test.in1, test.in2,
                    test.in3, actual, test.expected);
        }
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] previous = new double[100];
        previous[0] = poured;
        double[] current;
        for (int row = 0; row < query_row; row++) {
            current = new double[100];
            for (int col = 0; col <= row; col++) {
                double vol = (previous[col] - 1.0) / 2.0;
                if (vol > 0) {
                    current[col] += vol;
                    current[col + 1] += vol;
                }
            }
            previous = current;
        }
        return Math.min(1.0, previous[query_glass]);
    }

}