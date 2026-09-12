import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2) {}

        TestCase[] tests = {
                new TestCase(2, 3),
                new TestCase(3, 3),
                new TestCase(1, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String[] actual = s.createGrid(test.in1, test.in2);
            assert validateResult(actual) : "createGrid(%s, %s) == %s is invalid".formatted(test.in1, test.in2,
                    Arrays.toString(actual));
        }
    }

    private static boolean validateResult(String[] actual) {
        char[][] arr = new char[actual.length][];
        for (int row = 0; row < actual.length; row++) {
            arr[row] = actual[row].toCharArray();
        }
        for (int row = 0; row < actual.length - 1; row++) {
            for (int col = 0; col < actual[0].length() - 1; col++) {
                if (arr[row][col + 1] == '.' && arr[row + 1][col] == '.') {
                    return false;
                }
            }
        }
        int x = 0;
        int y = 0;
        while (true) {
            if ((x == actual[0].length() - 1) && (y == actual.length - 1)) {
                return true;
            }
            if (x < (actual[0].length() - 1) && arr[y][x + 1] == '.') {
                x++;
            } else if (y < (actual.length - 1) && arr[y + 1][x] == '.') {
                y++;
            } else {
                return false;
            }
        }
    }

    public String[] createGrid(int m, int n) {
        String[] result = new String[m];
        String r = new StringBuilder(n).append(".").repeat("#", n - 1).toString();
        for (int row = 0; row < m - 1; row++) {
            result[row] = r;
        }
        result[m - 1] = new StringBuilder(n).repeat(".", n).toString();
        return result;
    }

}