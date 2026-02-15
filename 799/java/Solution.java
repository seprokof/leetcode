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
        double[] glasses = new double[100];
        glasses[0] = poured;
        for (int row = 0; row < query_row; row++) {
            for (int col = row; col >= 0; col--) {
                double vol = Math.max((glasses[col] - 1.0) / 2.0, 0.0);
                glasses[col] = vol;
                glasses[col + 1] += vol;
            }
        }
        return Math.min(1.0, glasses[query_glass]);
    }

}