class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[][] in3, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 3, new int[][] { { 0, 1 }, { 1, 1 } }, 6),
                new TestCase(2, 2, new int[][] { { 1, 1 }, { 0, 0 } }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.oddCells(test.in1, test.in2, test.in3);
            assert test.expected == actual : "oddCells(%s, %s) == %s, want %s".formatted(test.in1, test.in2, actual,
                    test.expected);
        }
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int oddRows = 0;
        for (int r = 0; r < m; r++) {
            if (row[r] % 2 != 0) {
                oddRows++;
            }
        }
        int oddCols = 0;
        for (int c = 0; c < n; c++) {
            if (col[c] % 2 != 0) {
                oddCols++;
            }
        }
        return oddRows * (n - oddCols) + oddCols * (m - oddRows);
    }

}