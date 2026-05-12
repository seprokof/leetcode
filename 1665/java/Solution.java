import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 2, 4 }, { 4, 8 } }, 8),
                new TestCase(new int[][] { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 }, { 8, 9 } }, 32),
                new TestCase(new int[][] { { 1, 7 }, { 2, 8 }, { 3, 9 }, { 4, 10 }, { 5, 11 }, { 6, 12 } }, 27)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumEffort(deepCopy(test.in));
            assert test.expected == actual : "minimumEffort(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
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

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (l, r) -> (l[1] - l[0]) - (r[1] - r[0]));
        int result = 0;
        for (int[] task : tasks) {
            result = Math.max(result + task[0], task[1]);
        }
        return result;
    }

}