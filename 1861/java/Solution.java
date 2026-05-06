import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[][] in, char[][] expected) {}

        TestCase[] tests = {
                new TestCase(new char[][] { { '#', '.', '#' } }, new char[][] { { '.' }, { '#' }, { '#' } }),
                new TestCase(new char[][] { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } }, new char[][] { { '#', '.' }, { '#', '#' }, { '*', '*' }, { '.', '.' } }),
                new TestCase(new char[][] { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' }, { '#', '#', '#', '.', '#', '.' } }, new char[][] { { '.', '#', '#' }, { '.', '#', '#' }, { '#', '#', '*' }, { '#', '*', '.' }, { '#', '.', '*' }, { '#', '.', '.' } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            char[][] actual = s.rotateTheBox(test.in);
            assert Arrays.deepEquals(test.expected, actual) : "rotateTheBox(%s) = %s, want %s".formatted(
                    Arrays.deepToString(test.in), Arrays.deepToString(actual), Arrays.deepToString(test.expected));
        }
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            int col = m - i - 1;
            for (int j = n - 1, k = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    result[j][col] = '.';
                    result[k--][col] = '#';
                } else if (boxGrid[i][j] == '*') {
                    result[j][col] = '*';
                    k = j - 1;
                } else {
                    result[j][col] = '.';
                }
            }
        }
        return result;
    }

}