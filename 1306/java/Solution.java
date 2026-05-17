import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5, true),
                new TestCase(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 0, true),
                new TestCase(new int[] { 3, 0, 2, 1, 2 }, 2, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canReach(test.in1, test.in2);
            assert test.expected == actual : "canReach(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public boolean canReach(int[] arr, int start) {
        return visit(arr, start, new boolean[arr.length]);
    }

    private static boolean visit(int[] arr, int i, boolean[] visited) {
        if (i < 0 || i >= arr.length || visited[i]) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        visited[i] = true;
        return visit(arr, i + arr[i], visited) || visit(arr, i - arr[i], visited);
    }

}