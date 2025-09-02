import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } }, 0),
                new TestCase(new int[][] { { 6, 2 }, { 4, 4 }, { 2, 6 } }, 2),
                new TestCase(new int[][] { { 3, 1 }, { 1, 3 }, { 1, 1 } }, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfPairs(deepCopy(test.in));
            assert test.expected == actual : "numberOfPairs(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (l, r) -> l[0] == r[0] ? r[1] - l[1] : l[0] - r[0]);
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int yMin = Integer.MIN_VALUE;
            int yMax = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int y = points[j][1];
                if (yMax >= y && y > yMin) {
                    result++;
                    yMin = y;
                    if (y == yMax) {
                        break;
                    }
                }
            }
        }
        return result;
    }

}